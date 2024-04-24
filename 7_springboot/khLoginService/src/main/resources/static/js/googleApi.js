/**
 * 구글 로그인 연동 기능
 */

const CLIENT_ID = '56784730796-5st120v8e2971jaloelcchilqm1p4jdp.apps.googleusercontent.com';
const REDIRECT_URL ='http://localhost:8080/login/oauth/google';

window.onload = () => {

    document.querySelector("#btn-glogin").onclick = () => {

        const google_login_url = 'https://accounts.google.com/o/oauth2/v2/auth'
                                + '?client_id=' + CLIENT_ID
                                + '&redirect_uri=' + REDIRECT_URL
                                + '&response_type=code'
                                + '&scope=email profile';

        location.href = google_login_url;

    }

}