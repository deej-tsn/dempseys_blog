
export default function Blog(params: any){



    return (
        <div className=" w-48 h-fit p-5 flex flex-col rounded-xl drop-shadow-lg bg-gray-500 transition-transform ease-out hover:scale-110">
            <h1 className=" m-2">{params.blog_title}</h1>
            <h3 className=" m-2">{params.blog_author}</h3>
            <p className=" m-5">{params.blog_content}</p>
            <footer>{params.tags}</footer>
        </div>
    );
}

