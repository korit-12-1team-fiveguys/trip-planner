import Header from "../components/layout/Header";
import "./MyPage.css";

export default function MyPage() {
  const triplist = [
    {id: 1, title: "부산 2박 3일", destination: "부산", date: "2026.04.10 - 2026.04.12"},
    {id: 2, title: "서울 당일치기", destination: "서울", date: "2026.04.18"},
    {id: 3, title: "제주도 가족여행", destination: "제주", date: "2026.05.01 - 2026.05.04"},
  ];

  return (
    <div className="mypage">
      <Header />

      <div className="mypage-body">
        <section className="mypage-profile">
          <div className="mypage-profile-card">
            <h1 className="mypage-title">마이페이지</h1>
            <p className="mypage-welcome">안녕하세요, 사용자님</p>
            <p className="mypage-email">email@example.com</p>
            <p className="mypage-description">
              나의 여행 계획을 확인하고 관리해보세요.
            </p>

            <div className="mypage-actions">
              <button className="mypage-action-btn">회원정보 수정</button>
              <button className="mypage-action-btn logout">로그아웃</button>
            </div>
          </div>
        </section>

        <section className="mypage-trips">
          <h2 className="mypage-section-title">내 여행 계획</h2>

          <div className="mypage-trip-list">
            {triplist.map((trip) => (
              <div key={trip.id} className="mypage-trip-card">
                <h3>{trip.title}</h3>
                <p>목적지: {trip.destination}</p>
                <p>여행 기간: {trip.date}</p>
                <button className="mypage-detail-btn">상세보기</button>
              </div>
            ))}
          </div>
        </section>
      </div>
    </div>
  );
}