import { useState, ChangeEvent } from "react";
import type { SignupRequest } from "../types/auth";
import Header from "../components/layout/Header";
import KakaoIcon from "../assets/icons/Kakao.png";
import GoogleIcon from "../assets/icons/google.png";
import LogoIcon from "../assets/icons/logo.png";
import "./SignupPage.css";

export default function SignupPage() {
  // 1. 입력 데이터를 관리할 State 생성
  const [formData, setFormData] = useState<SignupRequest>({
    email: "",
    password: "",
    name: "",
    phone: "",
  });
  const [passwordConfirm, setPasswordConfirm] = useState("");

  // 2. 입력값이 변경될 때 호출되는 핸들러
  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // 3. 회원가입 버튼 클릭 시 호출되는 핸들러
  const handleSubmit = () => {
    if (!formData.email || !formData.password || !passwordConfirm || !formData.name) {
      alert("필수 내용을 모두 입력해주세요.");
      return;
    }

    if (passwordConfirm !== formData.password) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
      return;
    }

    console.log("회원가입 시도 데이터:", formData);
    alert(`회원가입 시도: ${formData.email}`);
    // 여기서 실제 API 호출(axios 등)을 진행하면 됩니다.
  };

  return (
    <div className="signup-page">
      <Header />

      <div className="signup-page-body">
        <div className="signup-card">
          <div className="signup-header">
            <img src={LogoIcon} alt="로고 아이콘" className="signup-logo" />
          </div>
          <h1 className="signup-title">회원가입</h1>

          <p className="signup-subtitle">
            이메일과 비밀번호를 이용해 회원가입하세요
          </p>

          {/* input에 name과 value, onChange를 연결했습니다. */}
          <input
            className="signup-input"
            type="email"
            name="email"
            placeholder="* 이메일"
            value={formData.email}
            onChange={handleChange}
          />
          <input
            className="signup-input"
            type="password"
            name="password"
            placeholder="* 비밀번호"
            value={formData.password}
            onChange={handleChange}
          />
          <input
            className="signup-input"
            type="password"
            name="password-confirm"
            placeholder="* 비밀번호 확인"
            value={passwordConfirm}
            onChange={(e) => setPasswordConfirm(e.target.value)}
          />
          <input
            className="signup-input"
            type="string"
            name="name"
            placeholder="* 이름"
            value={formData.name}
            onChange={handleChange}
          />
          <input
            className="signup-input"
            type="string"
            name="phone"
            placeholder="전화번호 (예: 010-1234-5678)"
            value={formData.phone}
            onChange={handleChange}
          />

          <button className="signup-button" onClick={handleSubmit}>
            회원가입
          </button>

          <div className="signup-divider">또는</div>

          <button className="social-button" onClick={() => console.log("카카오 회원가입 클릭")}>
            <img src={KakaoIcon} alt="카카오 아이콘" className="social-icon"/>
            <span className="social-button-text">Kakao 계정으로 진행하기</span>
          </button>
          <button className="social-button" onClick={() => console.log("구글 회원가입 클릭")}>
            <img src={GoogleIcon} alt="구글 아이콘" className="social-icon"/>
            <span className="social-button-text">Google 계정으로 진행하기</span>
          </button>

          <p className="signup-login">
            이미 계정이 있으신가요? <span>지금 로그인하세요</span>
          </p>
        </div>
      </div>
    </div>
  );
}