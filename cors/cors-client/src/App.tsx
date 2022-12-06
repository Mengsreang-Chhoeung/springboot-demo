import { useCallback, useEffect, useState } from "react";

interface Post {
  id: number;
  title: string;
  slug: string;
  content: string;
  author: string;
  publishedOn: number;
}

function App() {
  const [post, setPost] = useState<Post[]>([]);

  const fetchPost = useCallback(async () => {
    const data = await fetch(`http://localhost:8080/api/post`);
    data.json().then((res) => {
      setPost(res);
    });
  }, []);

  useEffect(() => {
    fetchPost();
  }, []);

  return (
    <div style={{ fontFamily: "sans-serif" }}>
      {post.length > 0 ? (
        post.map((it) => (
          <div
            key={it.id}
            style={{
              border: "1px solid #222",
              borderRadius: "4px",
              marginBottom: "10px",
              padding: "5px",
            }}
          >
            <h3 style={{ marginTop: "5px", marginBottom: "4px" }}>
              {it.title}
            </h3>
            <small>
              {it.author} <mark>#{it.slug}</mark>{" "}
              <span>
                Published on {new Date(it.publishedOn).toLocaleDateString()}
              </span>
            </small>
            <hr />
            <p>{it.content}</p>
          </div>
        ))
      ) : (
        <p>No Data</p>
      )}
    </div>
  );
}

export default App;
