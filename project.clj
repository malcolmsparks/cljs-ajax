(defproject cljs-ajax "0.2.2"
  :x-clojurescript? true
  :description "A simple Ajax library for ClojureScript"
  :url "https://github.com/yogthos/cljs-ajax"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.cemerick/clojurescript.test "0.2.1"
                  :scope "test"]
                 [org.clojure/clojurescript "0.0-1978"]
                 ]
  :plugins [[lein-cljsbuild "1.0.0-SNAPSHOT"]
            [com.cemerick/clojurescript.test "0.2.1"]]
  :hooks [leiningen.cljsbuild]
  :profiles {:dev {:source-paths ["dev"]
                  :dependencies [[ring-server "0.3.1"]
                                 [fogus/ring-edn "0.2.0"]
                                 [ring/ring-json "0.2.0"]
                                 [org.clojure/tools.namespace "0.2.4"]]}}
  :cljsbuild
  {:builds
   {:dev  {:source-paths ["src"]
           :compiler {:output-to "target/main.js"
                      :optimizations :whitespace
                      :pretty-print true}}
    :test {:source-paths ["src" "test"]
           :incremental? true
           :compiler {:output-to "target/unit-test.js"
                      :optimizations :whitespace
                      :pretty-print true}}}
   :test-commands {"unit-tests"
                   ["phantomjs" :runner "target/unit-test.js"]}})
