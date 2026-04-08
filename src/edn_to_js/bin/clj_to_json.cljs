(ns edn-to-js.bin.clj-to-json
  (:require [edn-to-js.fs :refer [read-file]]
            [edn-to-js.translate :refer [clj->json]]))

(defn main! []
  (let [stdin (read-file 0)]
    (println (clj->json stdin))))
