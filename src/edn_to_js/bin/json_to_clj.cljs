(ns edn-to-js.bin.json-to-clj
  (:require [cljs.pprint]
            [edn-to-js.fs :refer [read-file]]
            [edn-to-js.translate :refer [json->clj]]))

(defn main! []
  (let [stdin (read-file 0)]
    (cljs.pprint/pprint (json->clj stdin))))
