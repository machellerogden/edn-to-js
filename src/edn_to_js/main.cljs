(ns edn-to-js.main
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]))

(defn edn->js [edn]
  (let [data (r/read-string edn)]
    (clj->js data)))

(defn reload! []
  (println "Code updated."))

(defn main! [])
