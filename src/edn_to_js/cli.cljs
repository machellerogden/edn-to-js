(ns edn-to-js.cli
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]))

(def fs (js/require "fs"))

(defn edn->js [edn]
  (clj->js (r/read-string edn)))

(defn json->clj [json]
  (js->clj (.parse js/JSON json) :keywordize-keys true))

(defn json-stringify [data]
  (.stringify js/JSON (clj->js data) nil 4))

(defn write-file [filename data]
  (.writeFileSync fs filename data "utf-8"))

(defn read-file [filename]
  (.readFileSync fs filename "utf-8"))

(defn json-spit [filename data]
  (write-file filename (json-stringify data)))

(defn json-slurp [filename]
  (json->clj (read-file filename)))

(defn spit [filename data]
  (write-file filename (pr-str data)))

(defn slurp [filename]
  (r/read-string (read-file filename)))

(defn reload! []
  (println "Code updated."))

(defn main! []
  (let [stdin (read-file 0)]
    (println (pr-str (json->clj stdin)))))
  
  
  
  
