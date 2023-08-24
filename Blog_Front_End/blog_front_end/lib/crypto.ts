const bcrypt = require('bcrypt');

const saltRounds = 10;

async function hashPassword(unhashed_password : String, salt : String){
    return bcrypt.hash(unhashed_password, salt).then(function(err:Error, hash:String){
        return hash;
    });
}

async function genSaltAndHash(unhashed_password: String){
    const salt = await bcrypt.genSalt(saltRounds);
    const hash = await bcrypt.hash(unhashed_password, salt);
    return [hash, salt];
}

export{
    hashPassword, 
    genSaltAndHash
}
