import React from 'react';

const Member = () => {
    const [userName, setUserName] = React.useState('');
    const onChangeName = (name) => {
        setUserName(name);
        console.log(userName);
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        alert(userName);
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
