(defproject pet-owners "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [expectations "2.1.4"]
                 [com.datomic/datomic-free "0.9.5327"]]
  :plugins [[lein-autoexpect "1.7.0"]
            [lein-datomic "0.2.0"]]
  :datomic {:install-location "/usr/local/Cellar/datomic/0.9.5302"
            :schemas ["resources/datomic" ["schema.edn"]]}
  :profiles {:dev
             {:datomic {:config "resources/datomic/free-transactor-template.properties"
                        :db-uri "datomic:free://localhost:4334/pet-owners-db"}}})
