(ns edn-to-js.translate
  (:require [cljs.reader :as r]))

;; Register a default tag handler so unknown tagged literals
;; (e.g. #inst, #uuid, custom tags) don't throw during read.
(reset! r/*default-data-reader-fn*
        (fn [tag value] (tagged-literal tag value)))

;; Teach clj->js how to convert TaggedLiteral cleanly,
;; otherwise it dumps internal record fields.
(extend-type TaggedLiteral
  IEncodeJS
  (-clj->js [x]
    #js {:tag (str (.-tag x))
         :form (clj->js (.-form x))}))

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
