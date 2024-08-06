import React from 'react';
import axios from "axios";

const Member = () => {
    const [userName, setUserName] = React.useState('');
    const onChangeName = (name) => {
        setUserName(name);
        console.log(userName);
    }
    const handleSubmit = async (event) => {
        event.preventDefault();
        // alert(userName);
        await axios.post('http://localhost:3000/members/new', {
            name: userName
        }).then((res) => {
            console.log(res.data);
        }).catch((err) => {
            console.log(err);
        })
        setUserName('');
    }
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>이름</label>
                <input  type="text"
                        name="name"
                        value={userName}
                        onChange={(e) => onChangeName(e.target.value)}
                />
                <button type="submit">등록</button>
            </form>
        </div>
    );
};

export default Member;
