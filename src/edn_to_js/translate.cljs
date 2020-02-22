(ns edn-to-js.translate
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]))

(defn edn->js [edn]
  (clj->js (r/read-string edn)))

(defn json->clj [json]
  (js->clj (.parse js/JSON json) :keywordize-keys true))

(defn json-stringify
  ([data]
   (json-stringify data nil))
  ([data format?]
   (let [js-data (clj->js data)]
     (if format?
       (.stringify js/JSON js-data nil 4)
       (.stringify js/JSON js-data)))))

(defn clj->json [clj]
  (json-stringify (clj->js (r/read-string clj))))
