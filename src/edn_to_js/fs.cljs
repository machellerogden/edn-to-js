(ns edn-to-js.fs
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]
            [edn-to-js.translate :refer [json-stringify json->clj]]
            ["fs" :as fs]))

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
