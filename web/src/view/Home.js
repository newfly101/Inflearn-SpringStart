import React from 'react';

const Home = () => {
    return (
        <div>
            <h1>HOME</h1>
            <div>
                <h1>Hello Spring</h1>
                <p>회원 기능</p>
                <p>
                    <a href="/members/new">회원 가입</a>
                    <span> </span>
                    <a href="/members">회원 목록</a>
                </p>
            </div>
        </div>
    );
};

export default Home;
