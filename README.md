# edn-to-js

> Convert EDN to JavaScript data. Tolerant of tagged literals (`#inst`, `#uuid`, custom tags).

## Usage

```js
import { ednToJs, cljToJson, jsonToClj, jsonStringify } from 'edn-to-js';

ednToJs('{:foo "bar"}');
// => { foo: 'bar' }

ednToJs('{:created #inst "2024-01-01T00:00:00Z"}');
// => { created: { tag: 'inst', form: '2024-01-01T00:00:00Z' } }

cljToJson('{:foo "bar"}');
// => '{"foo":"bar"}'

jsonToClj('{"foo":"bar"}');
// => { foo: 'bar' }
```

## CLI

```sh
echo '{:foo "bar"}' | edn-to-json
# {"foo":"bar"}

echo '{"foo":"bar"}' | json-to-edn
# {:foo "bar"}
```

## Migrating from 0.x

v1.0 is a full rewrite. The package is now ESM and exports named functions instead of a single CommonJS default.

```js
// Before (0.x)
const edn = require('edn-to-js');
edn('{:foo "bar"}');

// After (1.x)
import { ednToJs } from 'edn-to-js';
ednToJs('{:foo "bar"}');
```

Tagged literals like `#inst` and `#uuid` no longer throw. They are converted to `{ tag, form }` objects.

## License

MIT
