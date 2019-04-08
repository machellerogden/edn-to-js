(ns edn-to-js.main
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]))

(defn ^:export edn->js [edn]
  (let [data (r/read-string edn)]
    (clj->js data)))
