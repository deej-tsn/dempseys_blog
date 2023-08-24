CREATE SCHEMA blog_schema;

CREATE TABLE IF NOT EXISTS blog_schema.users (
    user_id SERIAL PRIMARY KEY,
    personal_first_name VARCHAR(50) NOT NULL,
    personal_second_name VARCHAR(50) NOT NULL,
    personal_email VARCHAR(255) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    SALT VARCHAR(255) NOT NULL,
    PASSHASH VARCHAR(255) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT current_timestamp,
    last_login TIMESTAMP NOT NULL DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS blog_schema.blog_post (
    blog_id SERIAL PRIMARY KEY,
    blog_name VARCHAR(50) NOT NULL,
    user_id INT NOT NULL,
    content TEXT NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT current_timestamp,
    FOREIGN KEY (user_id) REFERENCES blog_schema.users (user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS blog_schema.tag (
    tag_id SERIAL PRIMARY KEY,
    tag_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS blog_schema.blog_post_tags (
    tag_id INT NOT NULL,
    blog_id INT NOT NULL,
    PRIMARY KEY (tag_id, blog_id),
    FOREIGN KEY (tag_id) REFERENCES blog_schema.tag (tag_id) ON DELETE CASCADE,
    FOREIGN KEY (blog_id) REFERENCES blog_schema.blog_post (blog_id) ON DELETE CASCADE
);

