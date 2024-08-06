import React, {useEffect, useState} from 'react';
import axios from "axios";

const MemberList = () => {
    const [members, setMembers] = useState([]);

    useEffect(() => {
        const fetchMembers = async () => {
            try {
                const response = await axios.get("/members", {
                    headers : {
                        "Content-Type": "application/json"
                    }
                });
                setMembers(response.data);
                console.log("axios : ",response.data);
            } catch (e) {
                console.log("error : ", e);
            }
        };

        fetchMembers();
    }, []);


    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>이름</th>
                </tr>
                </thead>
                <tbody>
                {members && members.map((member, index) => (
                    <tr key={member.id}>
                        <td>{member.id}</td>
                        <td>{member.name}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default MemberList;
