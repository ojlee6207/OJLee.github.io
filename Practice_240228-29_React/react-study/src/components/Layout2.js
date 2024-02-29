import { NavLink, Outlet } from "react-router-dom";

export default function Layout2() {
    return (
        <>
            <nav>
                <NavLink to="/">Home</NavLink>&nbsp;
                <NavLink to="/component/class">클래스 컴포넌트</NavLink>&nbsp;
                <NavLink to="/component/functional">함수형 컴포넌트</NavLink>&nbsp;
                <NavLink to="/hook/context">UseContext 테스트</NavLink>&nbsp;
                <NavLink to="/addressBook">주소록</NavLink>
            </nav>
            <main>
                <section>
                    {/* 상단 메뉴에서 클릭된 경로(path) 기준으로
                        해당되는 컴포넌트가 표시 */}
                    <Outlet />
                </section>
            </main>
        </>
    )
}