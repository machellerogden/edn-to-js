(ns edn-to-js.bin.clj-to-json
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]
            [edn-to-js.fs :refer [read-file]]
            [edn-to-js.translate :refer [clj->json]]))

(defn reload! []
  (println "Code updated."))

(defn main! []
  (let [stdin (read-file 0)]
    (println (clj->json stdin))))
