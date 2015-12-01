(ns pet-owners.core
  (:require [datomic.api :as d]))

;; ------ Database connection ------

;; (def uri "datomic:free://localhost:4334/pet-owners-db")
;; (def conn (d/connect uri))
(def conn nil)

;; ------ Helper functions ------

(defn find-pet-owner-id [owner-name]
  (ffirst (d/q '[:find ?eid
                 :in $ ?owner-name
                 :where [?eid :owner/name ?owner-name]]
               (d/db conn)
               owner-name)))

;; ------ Query functions ------

(defn add-pet-owner [owner-name]
  @(d/transact conn [{:db/id (d/tempid :db.part/user)
                      :owner/name owner-name}]))

(defn add-pet [pet-name owner-name]
  (let [pet-id (d/tempid :db.part/user)]
      @(d/transact conn [{:db/id pet-id
                          :pet/name pet-name}
                         {:db/id (find-pet-owner-id owner-name)
                          :owner/pets pet-id}])))

;;http://www.learndatalogtoday.org/
(defn find-all-pet-owners []
  (d/q '[:find ?owner-name
         :where [_ :owner/name ?owner-name]]
       (d/db conn)))

(defn find-pets-for-owner [owner-name]
  (d/q '[:find ?pet-name
         :in $ ?owner-name
         :where [?eid :owner/name ?owner-name]
                [?eid :owner/pets ?pet]
                [?pet :pet/name ?pet-name]]
       (d/db conn)
       owner-name))

;; (add-pet-owner "Bob")
;; (find-all-pet-owners)
;; (add-pet "Sooty" "Bob")
;; (find-pets-for-owner "Bob")
