Validator = {
  require: function (value, text) {
    if (Tool.isEmpty(value)) {
      Toast.warning(text + "can not be null");
      return false;
    } else {
      return true
    }
  },

  length: function (value, text, min, max) {
    var regPos = /^[0-9]+.?[0-9]*/;
    if (regPos.test(value) && !Tool.isEmpty(value)) {
      return true;
    } else if (Tool.isEmpty(value)) {
      return true;
    } else {
      Toast.warning(text + " must be valid number!");
      return false;
    }
    if (Tool.isEmpty(value)) {
      return true;
    }
    if (!Tool.isLength(value, min, max)) {
      Toast.warning(text + "length" + min + "~" + max + "digits");
      return false;
    } else {
      return true
    }
  }
};