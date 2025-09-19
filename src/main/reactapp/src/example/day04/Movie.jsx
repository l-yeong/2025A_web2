import axios from "axios";
import './Movie.css'
import { useEffect, useState } from "react";

export default function Movie(props) {

    // [1] 입력받은 데이터들을 관리하는 useState
    //영화 등록 
    const [mtitle, setMtitle] = useState('');
    const [mname, setMname] = useState('');
    const [mpwd, setMpwd] = useState('');
    const [mgenre, setMgenre] = useState('');
    const [mcontent, setMcontent] = useState('');
    //리뷰 등록
    const [rcontent, setRcontent] = useState('');
    const [rpwd, setRpwd] = useState('');
    const [mno, setMno] = useState('');

    //[2] 등록 정의
    //영화 등록
    const movieWrite = async () => {
        const movieAdd = { mtitle, mname, mpwd, mgenre, mcontent };
        const response = await axios.post('http://localhost:8080/movie', movieAdd);
        //등록후 초기화
        setMtitle('');
        setMname('');
        setMpwd('');
        setMgenre('');
        setMcontent('');
        //재렌더링
        moviePrint();
    }//func end
    //리뷰 등록
    const reviewWrite = async () => {

        const reviewAdd = { mno, rcontent, rpwd }
        const response = await axios.post('http://localhost:8080/review', reviewAdd);
        console.log(response.data);
        //등록 후 초기화
        setRcontent('');
        setRpwd('');
        setMno('');
        //재렌더링
        reviewPrint();
    }

    //[3] 전체조회 정의
    //영화 
    const [movieArray, setMovieArray] = useState([]);
    //리뷰
    const [reviewArray, setReviewArray] = useState([]);

    //영화 조회
    const moviePrint = async () => {
        const response = await axios.get('http://localhost:8080/movie');
        setMovieArray(response.data);
    }//func end

    //리뷰조회
    const reviewPrint = async () => {
        const response = await axios.get('http://localhost:8080/review');
        setReviewArray(response.data);
        console.log(response.data)
    }

    //[4] 최초컴포넌트 실행
    useEffect(() => { moviePrint(), reviewPrint() }, []);

    //[5] 삭제 정의
    //영화 조회
    const movieDelete = async (mno, mpwd) => {
        const response = await axios.delete(`http://localhost:8080/movie?mno=${mno}&mpwd=${mpwd}`)
        if (response.data == true) {
            setMovieArray(movieArray => movieArray.filter(num => num.mno != mno));
            alert("삭제 완료");
        } else {
            alert("삭제 실패");
        }//if end
    }//func end
    //리뷰 조회
    const reviewDelete = async (rno, rpwd) => {
        const response = await axios.delete(`http://localhost:8080/review?rno=${rno}&rpwd=${rpwd}`)
        if (response.data == true) {
            setReviewArray(reviewArray => reviewArray.filter(num => num.rno != rno))
            alert("삭제 완료");
        } else {
            alert("삭제 실패");
        }//if end
    }


    //---------------------- return ----------------------//
    return (<>

        <div className="movie-form">
            <h1>영화 등록</h1>
            <input placeholder="영화제목" value={mtitle} onChange={(e) => { setMtitle(e.target.value) }} />
            <input placeholder="장르" value={mgenre} onChange={(e) => { setMgenre(e.target.value) }} />

            <input placeholder="감독이름" value={mname} onChange={(e) => { setMname(e.target.value) }} />
            <input placeholder="비밀번호" type="password" value={mpwd} onChange={(e) => { setMpwd(e.target.value) }} />

            <textarea placeholder="소개글" value={mcontent} onChange={(e) => { setMcontent(e.target.value) }} />

            <button onClick={movieWrite}>영화 등록</button>
        </div>


        {
            movieArray.map((m) => {
                const relatedReviews = reviewArray.filter(r => r.mno === m.mno);

                return (
                    <div key={m.mno} className="movie-card">
                        <div className="movie-info-block">
                            <strong>제목</strong>
                            <span>{m.mtitle}</span>
                        </div>
                        <div className="movie-info-block">
                            <strong>장르</strong>
                            <span>{m.mgenre}</span>
                        </div>
                        <div className="movie-info-block">
                            <strong>감독</strong>
                            <span>{m.mname}</span>
                        </div>
                        <div className="movie-info-block">
                            <strong>소개</strong>
                            <span>{m.mcontent}</span>
                        </div>
                        <button onClick={() => {
                            const mpwd = prompt("비밀번호 입력");
                            if (!mpwd || mpwd.trim() === '') return;
                            movieDelete(m.mno, mpwd);
                        }}>삭제</button>

                        <div className="review-section">
                            <h3>리뷰 작성</h3>
                            <input placeholder="영화번호" value={mno} onChange={(e) => { setMno(e.target.value) }} /><br />
                            <textarea placeholder="리뷰작성" value={rcontent} onChange={(e) => { setRcontent(e.target.value) }} /><br />
                            <input placeholder="비밀번호" type="password" value={rpwd} onChange={(e) => { setRpwd(e.target.value) }} /><br />
                            <button onClick={reviewWrite}>리뷰등록</button>

                            <h4>리뷰 목록</h4>
                            <div className="review-list">
                                {
                                    relatedReviews.length === 0
                                        ? <p>등록된 리뷰가 없습니다.</p>
                                        : relatedReviews.map(r => (
                                            <div key={r.rno} className="review-card">
                                                <span>{r.rcontent}</span>
                                                <button onClick={() => {
                                                    const rpwd = prompt("비밀번호 입력");
                                                    if (!rpwd || rpwd.trim() === '') return;
                                                    reviewDelete(r.rno, rpwd);
                                                }}>삭제</button>
                                            </div>
                                        ))
                                }
                            </div>
                        </div>
                    </div>
                )
            })
        }

    </>)
}//func end