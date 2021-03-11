var exec = require('cordova/exec');

exports.initialize = function (token, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'initialize', [token]);
};

exports.doPostToken = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'doPostToken', [arg0]);
};

exports.pageView = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'pageView', [arg0]);
};

exports.productView = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'productView', [arg0]);
};

exports.add2Cart = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'add2Cart', [arg0]);
};

exports.removeFromCart = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'removeFromCart', [arg0]);
};

exports.placeOrder = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'placeOrder', [arg0]);
};

exports.postCart = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'postCart', [arg0]);
};

exports.postContactEmail = function (arg0, success, error) {
    exec(success, error, 'fbsdkconsumerplugin', 'postContactEmail', [arg0]);
};
