import { genSaltAndHash } from "../lib/crypto";

export default function InsertUserForm(){
    

    function checkValidPassword(password : String) : boolean {
        return false;
    }

    async function handleSubmit(data : FormData) {
        'use server'
        if(data.get("password") === null){
            return Error;
        } else{
            let [hash,salt] = await genSaltAndHash(data.get("password") as string);

            let user = {
                personal_first_name:data.get("first_name"),
                personal_second_name : data.get("last_name"),
                personal_email: data.get("email"),
                username : data.get("username"),
                passhash: hash,
                salt: salt
            }

            try {
                const response = await fetch('http://localhost:3000/api/users/insertUser', {
                  method: 'POST',
                  headers: {
                    'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(user)
                });
                const data = await response.json();
                console.log(data)
              } catch (error) {
                console.error(error);
              }
        }

    }

    
    return (
        <div className="bg-gray-500 rounded-xl drop-shadow-lg">
            <form action={handleSubmit} className="flex flex-col m-2">
                <label htmlFor="first_name">First name:</label>
                <input type="text" id="first_name" name="first_name" required/>

                <label htmlFor="last_name">Last name:</label>
                <input type="text" id="last_name" name="last_name" required/>

                <label htmlFor="email">Email:</label>
                <input type="email" id="email" name="email" required/>

                <label htmlFor="username">Username</label>
                <input type="text" id="username" name="username" required/>

                <label htmlFor="password">Password</label>
                <input type="password" id="password" name="password" required />


                <button type="submit">Submit</button>
            </form>
        </div>


    )
}