# pet-owners

Following: [Datomic: up and running](https://www.youtube.com/watch?v=ao7xEwCjrWQ)


## Usage

I installed datomic using [Brew](http://brew.sh/), so I needed to symlink the `transactor`

```
ln -s /usr/local/Cellar/datomic/0.9.5302/bin/datomic-transactor /usr/local/Cellar/datomic/0.9.5302/bin/transactor
```

To start datomic:

```
lein datomic start
```

Next initialise datomic:

```
lein datomic initialize
```

Now run tests:

```
lein autoexpect
```


## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
