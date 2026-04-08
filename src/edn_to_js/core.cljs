(ns edn-to-js.core
  (:require [edn-to-js.translate :as translate]))

(def edn->js translate/edn->js)
(def json->clj translate/json->clj)
(def clj->json translate/clj->json)
(def json-stringify translate/json-stringify)

