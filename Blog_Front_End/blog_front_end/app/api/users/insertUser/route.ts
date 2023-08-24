import { NextResponse } from "next/server";

export async function POST(req : any) {
    const { personal_first_name, personal_second_name,personal_email, username, passhash, salt} = await req.json();
    const API_ENDPOINT = 'http://localhost:8080/api/insertUser';
    
    const res = await fetch(API_ENDPOINT, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ personal_first_name, personal_second_name,personal_email, username, passhash, salt })
    });

    const data = await res.json();
    return NextResponse.json(data);
}