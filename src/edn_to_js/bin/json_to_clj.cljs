(ns edn-to-js.bin.json-to-clj
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]
            [edn-to-js.fs :refer [read-file]]
            [edn-to-js.translate :refer [json->clj]]))

(defn reload! []
  (println "Code updated."))

(defn main! []
  (let [stdin (read-file 0)]
    (println (pr-str (json->clj stdin)))))
