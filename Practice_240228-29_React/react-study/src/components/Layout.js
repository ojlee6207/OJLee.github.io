import '../css/common.css'

function Layout() {
    return (
        <>
            {/* <div id="sidebar">
                <h1>React Router Contacts</h1>
                <form id="search-form" role="search">
                    <input id="q" aria-label="Search contacts"
                        placeholder="Search" name="q" />
                    <div id="search-spinner" aria-hidden hidden={true} />
                    <div className="sr-only" aria-live="polite"></div>
                </form>
                <form method="post">
                    <button type="submit">New</button>
                </form>
            </div> */}
            <nav>
                <h3>컴포넌트</h3>
                <ul>
                    {/* 클래스형 컴포넌트 클릭시 "/component/class"로 연결 */}
                    <li><a href={"/component/class"}>클래스형 컴포넌트</a></li>
                    <li><a href={"/component/functional"}>함수형 컴포넌트</a></li>
                </ul>
                <h3>훅(Hook)</h3>
                <ul>
                    <li><a href={"/hook/state"}>상태 관련 Hook</a></li>
                    <li><a href={"/hook/effect"}>렌더링 시점 관련 Hook (useEffect)</a></li>
                    <li><a href={"/hook/context"}>Context 관련 Hook (useContext)</a></li>
                    <li><a href={"/hook/memo"}>계산 결과 캐싱 관련 Hook(useMemo)</a></li>
                    <li><a href={"/hook/callback"}>함수 캐싱 관련 Hook(useCallback)</a></li>
                    <li><a href={"/hook/dom"}>특정 DOM 접근 관련 Hook(useRef)</a></li>
                </ul>
            </nav>
            <div id="detail"></div>
        </>
    );
}

export default Layout;