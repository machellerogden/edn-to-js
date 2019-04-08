# edn-to-js

> A simple ClojureScript `edn->js` implementation, exported as a commonjs module.

After finding an appalling lack of anything sensible for converting EDN to JavaScript data on NPM I took literally 5 minutes and wrote, built and published this.

## Usage

```js
const edn = require('edn-to-js');
edn('{:foo "bar"}'); // => { foo: 'bar' }
```

## License

MIT
