// { "framework": "Vue"} 

!function(t){function e(r){if(n[r])return n[r].exports;var o=n[r]={i:r,l:!1,exports:{}};return t[r].call(o.exports,o,o.exports,e),o.l=!0,o.exports}var n={};e.m=t,e.c=n,e.d=function(t,n,r){e.o(t,n)||Object.defineProperty(t,n,{configurable:!1,enumerable:!0,get:r})},e.n=function(t){var n=t&&t.__esModule?function(){return t.default}:function(){return t};return e.d(n,"a",n),n},e.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},e.p="",e(e.s=0)}([function(t,e,n){"use strict";var r=n(1),o=r.router,i=n(7);new Vue(Vue.util.extend({el:"#root",router:o},i)),o.push("/")},function(t,e,n){"use strict";function r(t){return t&&t.__esModule?t:{default:t}}Object.defineProperty(e,"__esModule",{value:!0}),e.router=void 0;var o=n(2),i=r(o),a=n(3),s=r(a);Vue.use(i.default);e.router=new i.default({routes:[{path:"/",name:"HelloWorld",component:s.default}]})},function(t,e,n){"use strict";/*!
  * vue-router v3.1.2
  * (c) 2019 Evan You
  * @license MIT
  */
function r(t,e){if(!t)throw new Error("[vue-router] "+e)}function o(t,e){}function i(t){return Object.prototype.toString.call(t).indexOf("Error")>-1}function a(t,e){return e instanceof t||e&&(e.name===t.name||e._name===t._name)}function s(t,e){for(var n in e)t[n]=e[n];return t}function c(t,e){switch(typeof e){case"undefined":return;case"object":return e;case"function":return e(t);case"boolean":return e?t.params:void 0;default:o(!1,'props in "'+t.path+'" is a '+typeof e+", expecting an object, function or boolean.")}}function u(t,e,n){void 0===e&&(e={});var r,i=n||p;try{r=i(t||"")}catch(t){o(!1,t.message),r={}}for(var a in e)r[a]=e[a];return r}function p(t){var e={};return(t=t.trim().replace(/^(\?|#|&)/,""))?(t.split("&").forEach(function(t){var n=t.replace(/\+/g," ").split("="),r=Vt(n.shift()),o=n.length>0?Vt(n.join("=")):null;void 0===e[r]?e[r]=o:Array.isArray(e[r])?e[r].push(o):e[r]=[e[r],o]}),e):e}function f(t){var e=t?Object.keys(t).map(function(e){var n=t[e];if(void 0===n)return"";if(null===n)return Ut(e);if(Array.isArray(n)){var r=[];return n.forEach(function(t){void 0!==t&&(null===t?r.push(Ut(e)):r.push(Ut(e)+"="+Ut(t)))}),r.join("&")}return Ut(e)+"="+Ut(n)}).filter(function(t){return t.length>0}).join("&"):null;return e?"?"+e:""}function l(t,e,n,r){var o=r&&r.options.stringifyQuery,i=e.query||{};try{i=h(i)}catch(t){}var a={name:e.name||t&&t.name,meta:t&&t.meta||{},path:e.path||"/",hash:e.hash||"",query:i,params:e.params||{},fullPath:v(e,o),matched:t?d(t):[]};return n&&(a.redirectedFrom=v(n,o)),Object.freeze(a)}function h(t){if(Array.isArray(t))return t.map(h);if(t&&"object"==typeof t){var e={};for(var n in t)e[n]=h(t[n]);return e}return t}function d(t){for(var e=[];t;)e.unshift(t),t=t.parent;return e}function v(t,e){var n=t.path,r=t.query;void 0===r&&(r={});var o=t.hash;void 0===o&&(o="");var i=e||f;return(n||"/")+i(r)+o}function y(t,e){return e===Nt?t===e:!!e&&(t.path&&e.path?t.path.replace(Bt,"")===e.path.replace(Bt,"")&&t.hash===e.hash&&m(t.query,e.query):!(!t.name||!e.name)&&(t.name===e.name&&t.hash===e.hash&&m(t.query,e.query)&&m(t.params,e.params)))}function m(t,e){if(void 0===t&&(t={}),void 0===e&&(e={}),!t||!e)return t===e;var n=Object.keys(t),r=Object.keys(e);return n.length===r.length&&n.every(function(n){var r=t[n],o=e[n];return"object"==typeof r&&"object"==typeof o?m(r,o):String(r)===String(o)})}function g(t,e){return 0===t.path.replace(Bt,"/").indexOf(e.path.replace(Bt,"/"))&&(!e.hash||t.hash===e.hash)&&w(t.query,e.query)}function w(t,e){for(var n in e)if(!(n in t))return!1;return!0}function b(t,e,n){var r=t.charAt(0);if("/"===r)return t;if("?"===r||"#"===r)return e+t;var o=e.split("/");n&&o[o.length-1]||o.pop();for(var i=t.replace(/^\//,"").split("/"),a=0;a<i.length;a++){var s=i[a];".."===s?o.pop():"."!==s&&o.push(s)}return""!==o[0]&&o.unshift(""),o.join("/")}function _(t){var e="",n="",r=t.indexOf("#");r>=0&&(e=t.slice(r),t=t.slice(0,r));var o=t.indexOf("?");return o>=0&&(n=t.slice(o+1),t=t.slice(0,o)),{path:t,query:n,hash:e}}function x(t){return t.replace(/\/\//g,"/")}function k(t,e){for(var n,r=[],o=0,i=0,a="",s=e&&e.delimiter||"/";null!=(n=Qt.exec(t));){var c=n[0],u=n[1],p=n.index;if(a+=t.slice(i,p),i=p+c.length,u)a+=u[1];else{var f=t[i],l=n[2],h=n[3],d=n[4],v=n[5],y=n[6],m=n[7];a&&(r.push(a),a="");var g=null!=l&&null!=f&&f!==l,w="+"===y||"*"===y,b="?"===y||"*"===y,_=n[2]||s,x=d||v;r.push({name:h||o++,prefix:l||"",delimiter:_,optional:b,repeat:w,partial:g,asterisk:!!m,pattern:x?j(x):m?".*":"[^"+A(_)+"]+?"})}}return i<t.length&&(a+=t.substr(i)),a&&r.push(a),r}function R(t,e){return O(k(t,e))}function C(t){return encodeURI(t).replace(/[\/?#]/g,function(t){return"%"+t.charCodeAt(0).toString(16).toUpperCase()})}function E(t){return encodeURI(t).replace(/[?#]/g,function(t){return"%"+t.charCodeAt(0).toString(16).toUpperCase()})}function O(t){for(var e=new Array(t.length),n=0;n<t.length;n++)"object"==typeof t[n]&&(e[n]=new RegExp("^(?:"+t[n].pattern+")$"));return function(n,r){for(var o="",i=n||{},a=r||{},s=a.pretty?C:encodeURIComponent,c=0;c<t.length;c++){var u=t[c];if("string"!=typeof u){var p,f=i[u.name];if(null==f){if(u.optional){u.partial&&(o+=u.prefix);continue}throw new TypeError('Expected "'+u.name+'" to be defined')}if(Dt(f)){if(!u.repeat)throw new TypeError('Expected "'+u.name+'" to not repeat, but received `'+JSON.stringify(f)+"`");if(0===f.length){if(u.optional)continue;throw new TypeError('Expected "'+u.name+'" to not be empty')}for(var l=0;l<f.length;l++){if(p=s(f[l]),!e[c].test(p))throw new TypeError('Expected all "'+u.name+'" to match "'+u.pattern+'", but received `'+JSON.stringify(p)+"`");o+=(0===l?u.prefix:u.delimiter)+p}}else{if(p=u.asterisk?E(f):s(f),!e[c].test(p))throw new TypeError('Expected "'+u.name+'" to match "'+u.pattern+'", but received "'+p+'"');o+=u.prefix+p}}else o+=u}return o}}function A(t){return t.replace(/([.+*?=^!:${}()[\]|\/\\])/g,"\\$1")}function j(t){return t.replace(/([=!:$\/()])/g,"\\$1")}function T(t,e){return t.keys=e,t}function S(t){return t.sensitive?"":"i"}function $(t,e){var n=t.source.match(/\((?!\?)/g);if(n)for(var r=0;r<n.length;r++)e.push({name:r,prefix:null,delimiter:null,optional:!1,repeat:!1,partial:!1,asterisk:!1,pattern:null});return T(t,e)}function M(t,e,n){for(var r=[],o=0;o<t.length;o++)r.push(q(t[o],e,n).source);return T(new RegExp("(?:"+r.join("|")+")",S(n)),e)}function P(t,e,n){return L(k(t,n),e,n)}function L(t,e,n){Dt(e)||(n=e||n,e=[]),n=n||{};for(var r=n.strict,o=!1!==n.end,i="",a=0;a<t.length;a++){var s=t[a];if("string"==typeof s)i+=A(s);else{var c=A(s.prefix),u="(?:"+s.pattern+")";e.push(s),s.repeat&&(u+="(?:"+c+u+")*"),u=s.optional?s.partial?c+"("+u+")?":"(?:"+c+"("+u+"))?":c+"("+u+")",i+=u}}var p=A(n.delimiter||"/"),f=i.slice(-p.length)===p;return r||(i=(f?i.slice(0,-p.length):i)+"(?:"+p+"(?=$))?"),i+=o?"$":r&&f?"":"(?="+p+"|$)",T(new RegExp("^"+i,S(n)),e)}function q(t,e,n){return Dt(e)||(n=e||n,e=[]),n=n||{},t instanceof RegExp?$(t,e):Dt(t)?M(t,e,n):P(t,e,n)}function F(t,e,n){e=e||{};try{var r=Yt[t]||(Yt[t]=zt.compile(t));return e.pathMatch&&(e[0]=e.pathMatch),r(e,{pretty:!0})}catch(t){return o(!1,"missing param for "+n+": "+t.message),""}finally{delete e[0]}}function I(t,e,n,r){var i="string"==typeof t?{path:t}:t;if(i._normalized)return i;if(i.name)return s({},t);if(!i.path&&i.params&&e){i=s({},i),i._normalized=!0;var a=s(s({},e.params),i.params);if(e.name)i.name=e.name,i.params=a;else if(e.matched.length){var c=e.matched[e.matched.length-1].path;i.path=F(c,a,"path "+e.path)}else o(!1,"relative params navigation requires a current route.");return i}var p=_(i.path||""),f=e&&e.path||"/",l=p.path?b(p.path,f,n||i.append):f,h=u(p.query,i.query,r&&r.options.parseQuery),d=i.hash||p.hash;return d&&"#"!==d.charAt(0)&&(d="#"+d),{_normalized:!0,path:l,query:h,hash:d}}function U(t){if(!(t.metaKey||t.altKey||t.ctrlKey||t.shiftKey||t.defaultPrevented||void 0!==t.button&&0!==t.button)){if(t.currentTarget&&t.currentTarget.getAttribute){if(/\b_blank\b/i.test(t.currentTarget.getAttribute("target")))return}return t.preventDefault&&t.preventDefault(),!0}}function V(t){if(t)for(var e,n=0;n<t.length;n++){if(e=t[n],"a"===e.tag)return e;if(e.children&&(e=V(e.children)))return e}}function B(t){if(!B.installed||Wt!==t){B.installed=!0,Wt=t;var e=function(t){return void 0!==t},n=function(t,n){var r=t.$options._parentVnode;e(r)&&e(r=r.data)&&e(r=r.registerRouteInstance)&&r(t,n)};t.mixin({beforeCreate:function(){e(this.$options.router)?(this._routerRoot=this,this._router=this.$options.router,this._router.init(this),t.util.defineReactive(this,"_route",this._router.history.current)):this._routerRoot=this.$parent&&this.$parent._routerRoot||this,n(this,this)},destroyed:function(){n(this)}}),Object.defineProperty(t.prototype,"$router",{get:function(){return this._routerRoot._router}}),Object.defineProperty(t.prototype,"$route",{get:function(){return this._routerRoot._route}}),t.component("RouterView",Lt),t.component("RouterLink",ee);var r=t.config.optionMergeStrategies;r.beforeRouteEnter=r.beforeRouteLeave=r.beforeRouteUpdate=r.created}}function N(t,e,n,r){var o=e||[],i=n||Object.create(null),a=r||Object.create(null);t.forEach(function(t){D(o,i,a,t)});for(var s=0,c=o.length;s<c;s++)"*"===o[s]&&(o.push(o.splice(s,1)[0]),c--,s--);return{pathList:o,pathMap:i,nameMap:a}}function D(t,e,n,i,a,s){var c=i.path,u=i.name;r(null!=c,'"path" is required in a route configuration.'),r("string"!=typeof i.component,'route config "component" for path: '+String(c||u)+" cannot be a string id. Use an actual component instead.");var p=i.pathToRegexpOptions||{},f=H(c,a,p.strict);"boolean"==typeof i.caseSensitive&&(p.sensitive=i.caseSensitive);var l={path:f,regex:z(f,p),components:i.components||{default:i.component},instances:{},name:u,parent:a,matchAs:s,redirect:i.redirect,beforeEnter:i.beforeEnter,meta:i.meta||{},props:null==i.props?{}:i.components?i.props:{default:i.props}};if(i.children&&(i.name&&!i.redirect&&i.children.some(function(t){return/^\/?$/.test(t.path)})&&o(!1,"Named Route '"+i.name+"' has a default child route. When navigating to this named route (:to=\"{name: '"+i.name+"'\"), the default child route will not be rendered. Remove the name from this route and use the name of the default child route for named links instead."),i.children.forEach(function(r){var o=s?x(s+"/"+r.path):void 0;D(t,e,n,r,l,o)})),e[l.path]||(t.push(l.path),e[l.path]=l),void 0!==i.alias)for(var h=Array.isArray(i.alias)?i.alias:[i.alias],d=0;d<h.length;++d){var v=h[d];if(v!==c){var y={path:v,children:i.children};D(t,e,n,y,a,l.path||"/")}else o(!1,'Found an alias with the same value as the path: "'+c+'". You have to remove that alias. It will be ignored in development.')}u&&(n[u]?s||o(!1,'Duplicate named routes definition: { name: "'+u+'", path: "'+l.path+'" }'):n[u]=l)}function z(t,e){var n=zt(t,[],e),r=Object.create(null);return n.keys.forEach(function(e){o(!r[e.name],'Duplicate param keys in route with path: "'+t+'"'),r[e.name]=!0}),n}function H(t,e,n){return n||(t=t.replace(/\/$/,"")),"/"===t[0]?t:null==e?t:x(e.path+"/"+t)}function X(t,e){function n(t){N(t,p,f,h)}function i(t,n,r){var i=I(t,n,!1,e),a=i.name;if(a){var s=h[a];if(o(s,"Route with name '"+a+"' does not exist"),!s)return c(null,i);var u=s.regex.keys.filter(function(t){return!t.optional}).map(function(t){return t.name});if("object"!=typeof i.params&&(i.params={}),n&&"object"==typeof n.params)for(var l in n.params)!(l in i.params)&&u.indexOf(l)>-1&&(i.params[l]=n.params[l]);return i.path=F(s.path,i.params,'named route "'+a+'"'),c(s,i,r)}if(i.path){i.params={};for(var d=0;d<p.length;d++){var v=p[d],y=f[v];if(J(y.regex,i.path,i.params))return c(y,i,r)}}return c(null,i)}function a(t,n){var a=t.redirect,s="function"==typeof a?a(l(t,n,null,e)):a;if("string"==typeof s&&(s={path:s}),!s||"object"!=typeof s)return o(!1,"invalid redirect option: "+JSON.stringify(s)),c(null,n);var u=s,p=u.name,f=u.path,d=n.query,v=n.hash,y=n.params;if(d=u.hasOwnProperty("query")?u.query:d,v=u.hasOwnProperty("hash")?u.hash:v,y=u.hasOwnProperty("params")?u.params:y,p){return r(h[p],'redirect failed: named route "'+p+'" not found.'),i({_normalized:!0,name:p,query:d,hash:v,params:y},void 0,n)}if(f){var m=K(f,t);return i({_normalized:!0,path:F(m,y,'redirect route with path "'+m+'"'),query:d,hash:v},void 0,n)}return o(!1,"invalid redirect option: "+JSON.stringify(s)),c(null,n)}function s(t,e,n){var r=F(n,e.params,'aliased route with path "'+n+'"'),o=i({_normalized:!0,path:r});if(o){var a=o.matched,s=a[a.length-1];return e.params=o.params,c(s,e)}return c(null,e)}function c(t,n,r){return t&&t.redirect?a(t,r||n):t&&t.matchAs?s(t,n,t.matchAs):l(t,n,r,e)}var u=N(t),p=u.pathList,f=u.pathMap,h=u.nameMap;return{match:i,addRoutes:n}}function J(t,e,n){var r=e.match(t);if(!r)return!1;if(!n)return!0;for(var o=1,i=r.length;o<i;++o){var a=t.keys[o-1],s="string"==typeof r[o]?decodeURIComponent(r[o]):r[o];a&&(n[a.name||"pathMatch"]=s)}return!0}function K(t,e){return b(t,e.parent?e.parent.path:"/",!0)}function Q(){var t=window.location.protocol+"//"+window.location.host,e=window.location.href.replace(t,"");window.history.replaceState({key:at()},"",e),window.addEventListener("popstate",function(t){Y(),t.state&&t.state.key&&st(t.state.key)})}function W(t,e,n,o){if(t.app){var i=t.options.scrollBehavior;i&&(r("function"==typeof i,"scrollBehavior must be a function"),t.app.$nextTick(function(){var a=G(),s=i.call(t,e,n,o?a:null);s&&("function"==typeof s.then?s.then(function(t){ot(t,a)}).catch(function(t){r(!1,t.toString())}):ot(s,a))}))}}function Y(){var t=at();t&&(re[t]={x:window.pageXOffset,y:window.pageYOffset})}function G(){var t=at();if(t)return re[t]}function Z(t,e){var n=document.documentElement,r=n.getBoundingClientRect(),o=t.getBoundingClientRect();return{x:o.left-r.left-e.x,y:o.top-r.top-e.y}}function tt(t){return rt(t.x)||rt(t.y)}function et(t){return{x:rt(t.x)?t.x:window.pageXOffset,y:rt(t.y)?t.y:window.pageYOffset}}function nt(t){return{x:rt(t.x)?t.x:0,y:rt(t.y)?t.y:0}}function rt(t){return"number"==typeof t}function ot(t,e){var n="object"==typeof t;if(n&&"string"==typeof t.selector){var r=oe.test(t.selector)?document.getElementById(t.selector.slice(1)):document.querySelector(t.selector);if(r){var o=t.offset&&"object"==typeof t.offset?t.offset:{};o=nt(o),e=Z(r,o)}else tt(t)&&(e=et(t))}else n&&tt(t)&&(e=et(t));e&&window.scrollTo(e.x,e.y)}function it(){return ae.now().toFixed(3)}function at(){return se}function st(t){se=t}function ct(t,e){Y();var n=window.history;try{e?n.replaceState({key:se},"",t):(se=it(),n.pushState({key:se},"",t))}catch(n){window.location[e?"replace":"assign"](t)}}function ut(t){ct(t,!0)}function pt(t,e,n){var r=function(o){o>=t.length?n():t[o]?e(t[o],function(){r(o+1)}):r(o+1)};r(0)}function ft(t){return function(e,n,r){var a=!1,s=0,c=null;lt(t,function(t,e,n,u){if("function"==typeof t&&void 0===t.cid){a=!0,s++;var p,f=vt(function(e){dt(e)&&(e=e.default),t.resolved="function"==typeof e?e:Wt.extend(e),n.components[u]=e,--s<=0&&r()}),l=vt(function(t){var e="Failed to resolve async component "+u+": "+t;o(!1,e),c||(c=i(t)?t:new Error(e),r(c))});try{p=t(f,l)}catch(t){l(t)}if(p)if("function"==typeof p.then)p.then(f,l);else{var h=p.component;h&&"function"==typeof h.then&&h.then(f,l)}}}),a||r()}}function lt(t,e){return ht(t.map(function(t){return Object.keys(t.components).map(function(n){return e(t.components[n],t.instances[n],t,n)})}))}function ht(t){return Array.prototype.concat.apply([],t)}function dt(t){return t.__esModule||ce&&"Module"===t[Symbol.toStringTag]}function vt(t){var e=!1;return function(){for(var n=[],r=arguments.length;r--;)n[r]=arguments[r];if(!e)return e=!0,t.apply(this,n)}}function yt(t){if(!t)if(ne){var e=document.querySelector("base");t=e&&e.getAttribute("href")||"/",t=t.replace(/^https?:\/\/[^\/]+/,"")}else t="/";return"/"!==t.charAt(0)&&(t="/"+t),t.replace(/\/$/,"")}function mt(t,e){var n,r=Math.max(t.length,e.length);for(n=0;n<r&&t[n]===e[n];n++);return{updated:e.slice(0,n),activated:e.slice(n),deactivated:t.slice(n)}}function gt(t,e,n,r){var o=lt(t,function(t,r,o,i){var a=wt(t,e);if(a)return Array.isArray(a)?a.map(function(t){return n(t,r,o,i)}):n(a,r,o,i)});return ht(r?o.reverse():o)}function wt(t,e){return"function"!=typeof t&&(t=Wt.extend(t)),t.options[e]}function bt(t){return gt(t,"beforeRouteLeave",xt,!0)}function _t(t){return gt(t,"beforeRouteUpdate",xt)}function xt(t,e){if(e)return function(){return t.apply(e,arguments)}}function kt(t,e,n){return gt(t,"beforeRouteEnter",function(t,r,o,i){return Rt(t,o,i,e,n)})}function Rt(t,e,n,r,o){return function(i,a,s){return t(i,a,function(t){"function"==typeof t&&r.push(function(){Ct(t,e.instances,n,o)}),s(t)})}}function Ct(t,e,n,r){e[n]&&!e[n]._isBeingDestroyed?t(e[n]):r()&&setTimeout(function(){Ct(t,e,n,r)},16)}function Et(t){var e=decodeURI(window.location.pathname);return t&&0===e.indexOf(t)&&(e=e.slice(t.length)),(e||"/")+window.location.search+window.location.hash}function Ot(t){var e=Et(t);if(!/^\/#/.test(e))return window.location.replace(x(t+"/#"+e)),!0}function At(){var t=jt();return"/"===t.charAt(0)||($t("/"+t),!1)}function jt(){var t=window.location.href,e=t.indexOf("#");if(e<0)return"";t=t.slice(e+1);var n=t.indexOf("?");if(n<0){var r=t.indexOf("#");t=r>-1?decodeURI(t.slice(0,r))+t.slice(r):decodeURI(t)}else n>-1&&(t=decodeURI(t.slice(0,n))+t.slice(n));return t}function Tt(t){var e=window.location.href,n=e.indexOf("#");return(n>=0?e.slice(0,n):e)+"#"+t}function St(t){ie?ct(Tt(t)):window.location.hash=t}function $t(t){ie?ut(Tt(t)):window.location.replace(Tt(t))}function Mt(t,e){return t.push(e),function(){var n=t.indexOf(e);n>-1&&t.splice(n,1)}}function Pt(t,e,n){var r="hash"===n?"#"+e:e;return t?x(t+"/"+r):r}Object.defineProperty(e,"__esModule",{value:!0});var Lt={name:"RouterView",functional:!0,props:{name:{type:String,default:"default"}},render:function(t,e){var n=e.props,r=e.children,o=e.parent,i=e.data;i.routerView=!0;for(var a=o.$createElement,u=n.name,p=o.$route,f=o._routerViewCache||(o._routerViewCache={}),l=0,h=!1;o&&o._routerRoot!==o;){var d=o.$vnode&&o.$vnode.data;d&&(d.routerView&&l++,d.keepAlive&&o._inactive&&(h=!0)),o=o.$parent}if(i.routerViewDepth=l,h)return a(f[u],i,r);var v=p.matched[l];if(!v)return f[u]=null,a();var y=f[u]=v.components[u];i.registerRouteInstance=function(t,e){var n=v.instances[u];(e&&n!==t||!e&&n===t)&&(v.instances[u]=e)},(i.hook||(i.hook={})).prepatch=function(t,e){v.instances[u]=e.componentInstance},i.hook.init=function(t){t.data.keepAlive&&t.componentInstance&&t.componentInstance!==v.instances[u]&&(v.instances[u]=t.componentInstance)};var m=i.props=c(p,v.props&&v.props[u]);if(m){m=i.props=s({},m);var g=i.attrs=i.attrs||{};for(var w in m)y.props&&w in y.props||(g[w]=m[w],delete m[w])}return a(y,i,r)}},qt=/[!'()*]/g,Ft=function(t){return"%"+t.charCodeAt(0).toString(16)},It=/%2C/g,Ut=function(t){return encodeURIComponent(t).replace(qt,Ft).replace(It,",")},Vt=decodeURIComponent,Bt=/\/?$/,Nt=l(null,{path:"/"}),Dt=Array.isArray||function(t){return"[object Array]"==Object.prototype.toString.call(t)},zt=q,Ht=k,Xt=R,Jt=O,Kt=L,Qt=new RegExp(["(\\\\.)","([\\/.])?(?:(?:\\:(\\w+)(?:\\(((?:\\\\.|[^\\\\()])+)\\))?|\\(((?:\\\\.|[^\\\\()])+)\\))([+*?])?|(\\*))"].join("|"),"g");zt.parse=Ht,zt.compile=Xt,zt.tokensToFunction=Jt,zt.tokensToRegExp=Kt;var Wt,Yt=Object.create(null),Gt=[String,Object],Zt=[String,Array],te=function(){},ee={name:"RouterLink",props:{to:{type:Gt,required:!0},tag:{type:String,default:"a"},exact:Boolean,append:Boolean,replace:Boolean,activeClass:String,exactActiveClass:String,event:{type:Zt,default:"click"}},render:function(t){var e=this,n=this.$router,r=this.$route,i=n.resolve(this.to,r,this.append),a=i.location,c=i.route,u=i.href,p={},f=n.options.linkActiveClass,h=n.options.linkExactActiveClass,d=null==f?"router-link-active":f,v=null==h?"router-link-exact-active":h,m=null==this.activeClass?d:this.activeClass,w=null==this.exactActiveClass?v:this.exactActiveClass,b=c.redirectedFrom?l(null,I(c.redirectedFrom),null,n):c;p[w]=y(r,b),p[m]=this.exact?p[w]:g(r,b);var _=function(t){U(t)&&(e.replace?n.replace(a,te):n.push(a,te))},x={click:U};Array.isArray(this.event)?this.event.forEach(function(t){x[t]=_}):x[this.event]=_;var k={class:p},R=!this.$scopedSlots.$hasNormal&&this.$scopedSlots.default&&this.$scopedSlots.default({href:u,route:c,navigate:_,isActive:p[m],isExactActive:p[w]});if(R){if(1===R.length)return R[0];if(R.length>1||!R.length)return o(!1,'RouterLink with to="'+this.props.to+"\" is trying to use a scoped slot but it didn't provide exactly one child."),0===R.length?t():t("span",{},R)}if("a"===this.tag)k.on=x,k.attrs={href:u};else{var C=V(this.$slots.default);if(C){C.isStatic=!1;(C.data=s({},C.data)).on=x;(C.data.attrs=s({},C.data.attrs)).href=u}else k.on=x}return t(this.tag,k,this.$slots.default)}},ne="undefined"!=typeof window,re=Object.create(null),oe=/^#\d/,ie=ne&&function(){var t=window.navigator.userAgent;return(-1===t.indexOf("Android 2.")&&-1===t.indexOf("Android 4.0")||-1===t.indexOf("Mobile Safari")||-1!==t.indexOf("Chrome")||-1!==t.indexOf("Windows Phone"))&&(window.history&&"pushState"in window.history)}(),ae=ne&&window.performance&&window.performance.now?window.performance:Date,se=it(),ce="function"==typeof Symbol&&"symbol"==typeof Symbol.toStringTag,ue=function(t){function e(){t.call(this,"Navigating to current location is not allowed"),this.name=this._name="NavigationDuplicated"}return t&&(e.__proto__=t),e.prototype=Object.create(t&&t.prototype),e.prototype.constructor=e,e}(Error);ue._name="NavigationDuplicated";var pe=function(t,e){this.router=t,this.base=yt(e),this.current=Nt,this.pending=null,this.ready=!1,this.readyCbs=[],this.readyErrorCbs=[],this.errorCbs=[]};pe.prototype.listen=function(t){this.cb=t},pe.prototype.onReady=function(t,e){this.ready?t():(this.readyCbs.push(t),e&&this.readyErrorCbs.push(e))},pe.prototype.onError=function(t){this.errorCbs.push(t)},pe.prototype.transitionTo=function(t,e,n){var r=this,o=this.router.match(t,this.current);this.confirmTransition(o,function(){r.updateRoute(o),e&&e(o),r.ensureURL(),r.ready||(r.ready=!0,r.readyCbs.forEach(function(t){t(o)}))},function(t){n&&n(t),t&&!r.ready&&(r.ready=!0,r.readyErrorCbs.forEach(function(e){e(t)}))})},pe.prototype.confirmTransition=function(t,e,n){var r=this,s=this.current,c=function(t){!a(ue,t)&&i(t)&&(r.errorCbs.length?r.errorCbs.forEach(function(e){e(t)}):o(!1,"uncaught error during route navigation:")),n&&n(t)};if(y(t,s)&&t.matched.length===s.matched.length)return this.ensureURL(),c(new ue(t));var u=mt(this.current.matched,t.matched),p=u.updated,f=u.deactivated,l=u.activated,h=[].concat(bt(f),this.router.beforeHooks,_t(p),l.map(function(t){return t.beforeEnter}),ft(l));this.pending=t;var d=function(e,n){if(r.pending!==t)return c();try{e(t,s,function(t){!1===t||i(t)?(r.ensureURL(!0),c(t)):"string"==typeof t||"object"==typeof t&&("string"==typeof t.path||"string"==typeof t.name)?(c(),"object"==typeof t&&t.replace?r.replace(t):r.push(t)):n(t)})}catch(t){c(t)}};pt(h,d,function(){var n=[];pt(kt(l,n,function(){return r.current===t}).concat(r.router.resolveHooks),d,function(){if(r.pending!==t)return c();r.pending=null,e(t),r.router.app&&r.router.app.$nextTick(function(){n.forEach(function(t){t()})})})})},pe.prototype.updateRoute=function(t){var e=this.current;this.current=t,this.cb&&this.cb(t),this.router.afterHooks.forEach(function(n){n&&n(t,e)})};var fe=function(t){function e(e,n){var r=this;t.call(this,e,n);var o=e.options.scrollBehavior,i=ie&&o;i&&Q();var a=Et(this.base);window.addEventListener("popstate",function(t){var n=r.current,o=Et(r.base);r.current===Nt&&o===a||r.transitionTo(o,function(t){i&&W(e,t,n,!0)})})}return t&&(e.__proto__=t),e.prototype=Object.create(t&&t.prototype),e.prototype.constructor=e,e.prototype.go=function(t){window.history.go(t)},e.prototype.push=function(t,e,n){var r=this,o=this,i=o.current;this.transitionTo(t,function(t){ct(x(r.base+t.fullPath)),W(r.router,t,i,!1),e&&e(t)},n)},e.prototype.replace=function(t,e,n){var r=this,o=this,i=o.current;this.transitionTo(t,function(t){ut(x(r.base+t.fullPath)),W(r.router,t,i,!1),e&&e(t)},n)},e.prototype.ensureURL=function(t){if(Et(this.base)!==this.current.fullPath){var e=x(this.base+this.current.fullPath);t?ct(e):ut(e)}},e.prototype.getCurrentLocation=function(){return Et(this.base)},e}(pe),le=function(t){function e(e,n,r){t.call(this,e,n),r&&Ot(this.base)||At()}return t&&(e.__proto__=t),e.prototype=Object.create(t&&t.prototype),e.prototype.constructor=e,e.prototype.setupListeners=function(){var t=this,e=this.router,n=e.options.scrollBehavior,r=ie&&n;r&&Q(),window.addEventListener(ie?"popstate":"hashchange",function(){var e=t.current;At()&&t.transitionTo(jt(),function(n){r&&W(t.router,n,e,!0),ie||$t(n.fullPath)})})},e.prototype.push=function(t,e,n){var r=this,o=this,i=o.current;this.transitionTo(t,function(t){St(t.fullPath),W(r.router,t,i,!1),e&&e(t)},n)},e.prototype.replace=function(t,e,n){var r=this,o=this,i=o.current;this.transitionTo(t,function(t){$t(t.fullPath),W(r.router,t,i,!1),e&&e(t)},n)},e.prototype.go=function(t){window.history.go(t)},e.prototype.ensureURL=function(t){var e=this.current.fullPath;jt()!==e&&(t?St(e):$t(e))},e.prototype.getCurrentLocation=function(){return jt()},e}(pe),he=function(t){function e(e,n){t.call(this,e,n),this.stack=[],this.index=-1}return t&&(e.__proto__=t),e.prototype=Object.create(t&&t.prototype),e.prototype.constructor=e,e.prototype.push=function(t,e,n){var r=this;this.transitionTo(t,function(t){r.stack=r.stack.slice(0,r.index+1).concat(t),r.index++,e&&e(t)},n)},e.prototype.replace=function(t,e,n){var r=this;this.transitionTo(t,function(t){r.stack=r.stack.slice(0,r.index).concat(t),e&&e(t)},n)},e.prototype.go=function(t){var e=this,n=this.index+t;if(!(n<0||n>=this.stack.length)){var r=this.stack[n];this.confirmTransition(r,function(){e.index=n,e.updateRoute(r)},function(t){a(ue,t)&&(e.index=n)})}},e.prototype.getCurrentLocation=function(){var t=this.stack[this.stack.length-1];return t?t.fullPath:"/"},e.prototype.ensureURL=function(){},e}(pe),de=function(t){void 0===t&&(t={}),this.app=null,this.apps=[],this.options=t,this.beforeHooks=[],this.resolveHooks=[],this.afterHooks=[],this.matcher=X(t.routes||[],this);var e=t.mode||"hash";switch(this.fallback="history"===e&&!ie&&!1!==t.fallback,this.fallback&&(e="hash"),ne||(e="abstract"),this.mode=e,e){case"history":this.history=new fe(this,t.base);break;case"hash":this.history=new le(this,t.base,this.fallback);break;case"abstract":this.history=new he(this,t.base);break;default:r(!1,"invalid mode: "+e)}},ve={currentRoute:{configurable:!0}};de.prototype.match=function(t,e,n){return this.matcher.match(t,e,n)},ve.currentRoute.get=function(){return this.history&&this.history.current},de.prototype.init=function(t){var e=this;if(r(B.installed,"not installed. Make sure to call `Vue.use(VueRouter)` before creating root instance."),this.apps.push(t),t.$once("hook:destroyed",function(){var n=e.apps.indexOf(t);n>-1&&e.apps.splice(n,1),e.app===t&&(e.app=e.apps[0]||null)}),!this.app){this.app=t;var n=this.history;if(n instanceof fe)n.transitionTo(n.getCurrentLocation());else if(n instanceof le){var o=function(){n.setupListeners()};n.transitionTo(n.getCurrentLocation(),o,o)}n.listen(function(t){e.apps.forEach(function(e){e._route=t})})}},de.prototype.beforeEach=function(t){return Mt(this.beforeHooks,t)},de.prototype.beforeResolve=function(t){return Mt(this.resolveHooks,t)},de.prototype.afterEach=function(t){return Mt(this.afterHooks,t)},de.prototype.onReady=function(t,e){this.history.onReady(t,e)},de.prototype.onError=function(t){this.history.onError(t)},de.prototype.push=function(t,e,n){var r=this;if(!e&&!n&&"undefined"!=typeof Promise)return new Promise(function(e,n){r.history.push(t,e,n)});this.history.push(t,e,n)},de.prototype.replace=function(t,e,n){var r=this;if(!e&&!n&&"undefined"!=typeof Promise)return new Promise(function(e,n){r.history.replace(t,e,n)});this.history.replace(t,e,n)},de.prototype.go=function(t){this.history.go(t)},de.prototype.back=function(){this.go(-1)},de.prototype.forward=function(){this.go(1)},de.prototype.getMatchedComponents=function(t){var e=t?t.matched?t:this.resolve(t).route:this.currentRoute;return e?[].concat.apply([],e.matched.map(function(t){return Object.keys(t.components).map(function(e){return t.components[e]})})):[]},de.prototype.resolve=function(t,e,n){e=e||this.history.current;var r=I(t,e,n,this),o=this.match(r,e),i=o.redirectedFrom||o.fullPath;return{location:r,route:o,href:Pt(this.history.base,i,this.mode),normalizedTo:r,resolved:o}},de.prototype.addRoutes=function(t){this.matcher.addRoutes(t),this.history.current!==Nt&&this.history.transitionTo(this.history.getCurrentLocation())},Object.defineProperties(de.prototype,ve),de.install=B,de.version="3.1.2",ne&&window.Vue&&window.Vue.use(de),e.default=de},function(t,e,n){var r,o,i=[];i.push(n(4)),r=n(5);var a=n(6);o=r=r||{},"object"!=typeof r.default&&"function"!=typeof r.default||(o=r=r.default),"function"==typeof o&&(o=o.options),o.render=a.render,o.staticRenderFns=a.staticRenderFns,o._scopeId="data-v-656039f0",o.style=o.style||{},i.forEach(function(t){for(var e in t)o.style[e]=t[e]}),"function"==typeof __register_static_styles__&&__register_static_styles__(o._scopeId,i),t.exports=r},function(t,e){t.exports={item:{backgroundColor:"#00B4FF",flexDirection:"column",justifyContent:"center",height:"100"},content:{fontSize:"40",color:"#FFFFFF",textAlign:"center"},"display-img":{display:"flex",flexWrap:"wrap",flexDirection:"row",backgroundColor:"#FFFFFF"}}},function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=weex.requireModule("ToastModule"),o=weex.requireModule("CommunicateModule"),i=weex.requireModule("CameraModule"),a=weex.requireModule("PicPreviewModule"),s=weex.requireModule("TokenModule"),c=weex.requireModule("NativeViewModule"),u=weex.requireModule("LoadingModule");e.default={name:"App",data:function(){return{startIndex:0,test:"11",logo:"https://gw.alicdn.com/tfs/TB1yopEdgoQMeJjy1XaXXcSsFXa-640-302.png",pics:[]}},methods:{testToast:function(){r.showToast("I am a weex Module")},callPhone:function(){o.dial("88888888")},openCamera:function(){var t=this;i.takePhoto({limit:10},function(e){200===e.code&&(t.pics=t.pics.concat(e.data))})},openLightBox:function(t){this.startIndex=t,a.picPreview({index:t,images:this.pics})},getConstants:function(){s.getToken(function(t){t.token,t.apiUrl})},toNativePage:function(){c.gotoNativeView("main")},showLoading:function(){u.showLoading({message:"加载中"}),setTimeout(function(){u.hideLoading()},3e3)}}}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("list",[n("cell",{appendAsTree:!0,attrs:{append:"tree"},on:{click:t.testToast}},[t._m(0)]),n("cell",{appendAsTree:!0,attrs:{append:"tree"},on:{click:t.callPhone}},[t._m(1)]),n("cell",{appendAsTree:!0,attrs:{append:"tree"},on:{click:t.getConstants}},[t._m(2)]),n("cell",{appendAsTree:!0,attrs:{append:"tree"},on:{click:t.toNativePage}},[t._m(3)]),n("cell",{appendAsTree:!0,attrs:{append:"tree"},on:{click:t.showLoading}},[t._m(4)]),n("cell",{appendAsTree:!0,attrs:{append:"tree"},on:{click:t.openCamera}},[t._m(5)]),n("cell",{appendAsTree:!0,attrs:{append:"tree"}},[n("div",{staticClass:["display-img"]},t._l(t.pics,function(e,r){return n("image",{staticStyle:{width:"200px",height:"200px"},attrs:{src:e},on:{click:function(e){t.openLightBox(r)}}})}))])])},staticRenderFns:[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["item"]},[n("text",{staticClass:["content"]},[t._v("吐司提示")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["item"]},[n("text",{staticClass:["content"]},[t._v("拨号")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["item"]},[n("text",{staticClass:["content"]},[t._v("获取常量值")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["item"]},[n("text",{staticClass:["content"]},[t._v("原生页面跳转")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["item"]},[n("text",{staticClass:["content"]},[t._v("加载框")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["item"]},[n("text",{staticClass:["content"]},[t._v("打开相册")])])}]}},function(t,e,n){var r,o,i=[];i.push(n(8)),r=n(9);var a=n(10);o=r=r||{},"object"!=typeof r.default&&"function"!=typeof r.default||(o=r=r.default),"function"==typeof o&&(o=o.options),o.render=a.render,o.staticRenderFns=a.staticRenderFns,o._scopeId="data-v-1a4d8e3c",o.style=o.style||{},i.forEach(function(t){for(var e in t)o.style[e]=t[e]}),"function"==typeof __register_static_styles__&&__register_static_styles__(o._scopeId,i),t.exports=r},function(t,e){t.exports={greeting:{fontSize:"50",textAlign:"center"}}},function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={name:"App",data:function(){return{logo:"https://gw.alicdn.com/tfs/TB1yopEdgoQMeJjy1XaXXcSsFXa-640-302.png"}}}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:["wrapper"]},[n("text",{staticClass:["greeting"]},[t._v("native扩展调用示例")]),n("router-view")],1)},staticRenderFns:[]}}]);