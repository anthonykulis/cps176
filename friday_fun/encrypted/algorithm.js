var encrypt = function(msg, key){
   return msg.split('').map(function(char){
      var encrypted_byte = (char.charCodeAt(0) ^ key.charCodeAt(0)).toString(16);
      if(encrypted_byte.length == 1){ encrypted_byte = "0" + encrypted_byte; }
      return encrypted_byte;
   }).join('');

}
