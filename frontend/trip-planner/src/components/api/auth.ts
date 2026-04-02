import { LoginRequest, AuthResponse } from "../../types/auth";
import client from "./client";

export interface UserMeResponse {
  id: number;
  email: string;
  name: string;
  role: string;
  status: string;
}

export const getMe = async (): Promise<UserMeResponse> => {
  // 기존에 "/api/auth/me"라고 되어 있다면 "/auth/me"로 수정하세요.
  // baseURL이 http://localhost:8080/api 이라면 아래와 같이 적어야 합니다.
  const response = await client.get<UserMeResponse>("/auth/me"); 
  return response.data;
};

export const loginApi = async (data: LoginRequest) : Promise<AuthResponse> => {
    const response = await client.post<AuthResponse>('/auth/login', data);
    return response.data;
}