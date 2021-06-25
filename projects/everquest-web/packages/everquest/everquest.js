(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'everquest'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'everquest'.");
    }root.everquest = factory(typeof everquest === 'undefined' ? {} : everquest, kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var toChar = Kotlin.toChar;
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var StringBuilder_init = Kotlin.kotlin.text.StringBuilder_init_za3lpa$;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var throwCCE = Kotlin.throwCCE;
  var toByte = Kotlin.toByte;
  function SayHello(name) {
    println('Hello ' + name);
  }
  function Base64Encoder() {
  }
  Base64Encoder.prototype.encodeToString = function (src) {
    var encoded = this.encode(src);
    var $receiver = StringBuilder_init(encoded.length);
    var tmp$;
    for (tmp$ = 0; tmp$ !== encoded.length; ++tmp$) {
      var element = encoded[tmp$];
      $receiver.append_s8itvh$(toChar(element));
    }
    return $receiver.toString();
  };
  Base64Encoder.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Base64Encoder',
    interfaces: []
  };
  function main() {
    SayHello('bob');
  }
  function Base64Factory() {
    Base64Factory_instance = this;
  }
  Base64Factory.prototype.createEncoder = function () {
    return JsBase64Encoder_getInstance();
  };
  Base64Factory.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Base64Factory',
    interfaces: []
  };
  var Base64Factory_instance = null;
  function Base64Factory_getInstance() {
    if (Base64Factory_instance === null) {
      new Base64Factory();
    }return Base64Factory_instance;
  }
  function JsBase64Encoder() {
    JsBase64Encoder_instance = this;
  }
  JsBase64Encoder.prototype.encode = function (src) {
    var tmp$;
    var string = {v: src.toString()};
    println('jjjjsEnv ' + jsEnv.toString());
    if (isBroswer()) {
      var asciiStr = unescape(encodeURIComponent(src.toString()));
      string.v = window.btoa(asciiStr);
    } else {
      var buffer = Buffer.from(src);
      string.v = typeof (tmp$ = buffer.toString('base64')) === 'string' ? tmp$ : throwCCE();
    }
    var array = new Int8Array(string.v.length);
    var tmp$_0;
    tmp$_0 = array.length - 1 | 0;
    for (var i = 0; i <= tmp$_0; i++) {
      array[i] = toByte(string.v.charCodeAt(i) | 0);
    }
    return array;
  };
  JsBase64Encoder.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'JsBase64Encoder',
    interfaces: [Base64Encoder]
  };
  var JsBase64Encoder_instance = null;
  function JsBase64Encoder_getInstance() {
    if (JsBase64Encoder_instance === null) {
      new JsBase64Encoder();
    }return JsBase64Encoder_instance;
  }
  function isBroswer() {
    return jsEnv == 'browser';
  }
  function main_0() {
    SayHello('Hello from kotlin/js');
    println(greeting('base64'));
    console.log('Hello2222, ' + greet());
    console.log('Hello333, ' + greet2('aha'));
  }
  var jsEnv;
  function greeting(name) {
    return 'Hello, ' + name;
  }
  function greet() {
    return 'world32323';
  }
  function greet2(name) {
    return 'Hello, ' + name;
  }
  function greet3(name) {
    return greet2(name);
  }
  function fnHahah(name) {
    return 'Hello, ' + name;
  }
  var package$xyz = _.xyz || (_.xyz = {});
  var package$sfx = package$xyz.sfx || (package$xyz.sfx = {});
  package$sfx.SayHello_61zpoe$ = SayHello;
  var package$base64 = package$sfx.base64 || (package$sfx.base64 = {});
  package$base64.Base64Encoder = Base64Encoder;
  package$sfx.main = main;
  Object.defineProperty(package$base64, 'Base64Factory', {
    get: Base64Factory_getInstance
  });
  Object.defineProperty(package$base64, 'JsBase64Encoder', {
    get: JsBase64Encoder_getInstance
  });
  package$base64.isBroswer = isBroswer;
  package$base64.main = main_0;
  Object.defineProperty(package$base64, 'jsEnv', {
    get: function () {
      return jsEnv;
    }
  });
  package$base64.greeting = greeting;
  package$base64.greet = greet;
  package$base64.greet2 = greet2;
  package$base64.greet3 = greet3;
  package$base64.fnHahah_61zpoe$ = fnHahah;
  JsBase64Encoder.prototype.encodeToString = Base64Encoder.prototype.encodeToString;
  jsEnv = typeof window === 'undefined' ? 'nodejs' : 'browser';
  main();
  Kotlin.defineModule('everquest', _);
  return _;
}));

//# sourceMappingURL=everquest.js.map
