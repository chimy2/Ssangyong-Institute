<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
        <style>
            html,
            body {
                padding: 0 !important;
                margin: 0 !important;
                background-color: #fff !important;
                display: block;
                overflow: hidden;
            }

            body > div {
                margin: 0;
                padding: 0;
            }

            #main {
                width: 400px;
                height: 510px;
                margin: 3px;
                display: grid;
                grid-template-rows: repeat(12, 1fr);
            }

            #header {
            }

            #header > h2 {
                margin: 0px;
                margin-bottom: 10px;
                padding: 5px;
            }

            #list {
                border: 1px solid var(--border-color);
                box-sizing: content-box;
                padding: 0.5rem;
                grid-row-start: 2;
                grid-row-end: 12;
                font-size: 14px;
                overflow: auto;
            }

            #msg {
                margin-top: 3px;
            }

            #list .item {
                font-size: 14px;
                margin: 15px 0;
            }

            #list .item > div:first-child {
                display: flex;
            }

            #list .item.me > div:first-child {
                justify-content: flex-end;
            }

            #list .item.other > div:first-child {
                justify-content: flex-end;
                flex-direction: row-reverse;
            }

            #list .item > div:first-child > div:first-child {
                font-size: 10px;
                color: #777;
                margin: 3px 5px;
            }

            #list .item > div:first-child > div:nth-child(2) {
                border: 1px solid var(--border-color);
                display: inline-block;
                min-width: 100px;
                max-width: 250px;
                text-align: left;
                padding: 3px 7px;
            }

            #list .state.item > div:first-child > div:nth-child(2) {
                background-color: #eee;
            }

            #list .item > div:last-child {
                font-size: 10px;
                color: #777;
                margin-top: 5px;
            }

            #list .me {
                text-align: right;
            }

            #list .other {
                text-align: left;
            }

            #list .msg.me.item > div:first-child > div:nth-child(2) {
                background-color: rgba(255, 99, 71, 0.2);
            }

            #list .msg.other.item > div:first-child > div:nth-child(2) {
                background-color: rgba(100, 149, 237, 0.2);
            }

            #list .msg img {
                width: 150px;
            }
        </style>
    </head>
    <body>
        <!-- chat.jsp -->
        <div id="main">
            <div id="header">
                <h2>WebSocket <small>강아지</small></h2>
            </div>
            <div id="list"></div>
            <input type="text" id="msg" placeholer="대화 내용을 입력하세요." />
        </div>

        <!-- dayjs -->
        <script src="https://cdn.jsdelivr.net/npm/dayjs@1.11.13/dayjs.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="https://bit.ly/4cMuheh"></script>
        <script>
            /*
            	프로토콜 설계
            	- why? 전달하는 메세지가 무엇을 보냈는지 인식하기 위해
            	- 전달 메시지 형식
            		- code: 상태코드
            			- 1: 새로운 유저가 들어옴
            			- 2: 기존 유저가 나감
            			- 3: 메시지 전달
            			- 4:
            		- sender: 메시지 보내는 유저명
            		- receiver: 메시지를 받는 유저명
            		- content: 대화내용(메시지)
            		- regdate: 날짜/시간

            */

            let name; // 대화명

            // 대화명 설정 + 서버 연결
            const url = 'ws://localhost:8090/socket/chatserver.do';
            // const url = 'ws://192.168.10.30:8090/socket/chatserver.do';
            let ws;

            function connect(name) {
                $('#header small').text(name);
                this.name = name;

                // 연결하기 + 소켓 생성
                ws = new WebSocket(url);
                log('서버에게 연결을 시도합니다.');

                // 네트워크 통신 > 개발자가 하는 작업 중 상급
                ws.onopen = (evt) => {
                    log('서버와 연결되었습니다.');

                    // 서버와 접속 확인 > 접속한 유저명을 서버에게 전달
                    // ws.send('강아지');

                    const message = {
                        code: 1,
                        sender: name,
                        // receiver: '',
                        // content: '',
                        // regdate: '2024-10-24 12:24:10',
                        regdate: dayjs().format('YYYY-MM-DD HH:mm:ss'),
                    };

                    // 객체 > JSON 문자열
                    // alert(JSON.stringify(message));

                    ws.send(JSON.stringify(message));
                };

                ws.onmessage = (evt) => {
                    log('메시지를 수신했습니다.');

                    const message = JSON.parse(evt.data);

                    // document.title = message.sender;

                    if (message.code == '1') {
                        // print('', `[강아지]님이 들어왔습니다.`)
                        print(
                            '',
                            `[\${message.sender}]님이 들어왔습니다.`,
                            'other',
                            'state',
                            message.regdate
                        );
                    } else if (message.code == '2') {
                        print(
                            '',
                            `[\${message.sender}]님이 나갔습니다.`,
                            'other',
                            'state',
                            message.regdate
                        );
                    } else if (message.code == '3') {
                        print(
                            message.sender,
                            message.content,
                            'other',
                            'msg',
                            message.regdate
                        );
                    } else if (message.code == '4') {
                        printEmoticon(
                            message.sender,
                            message.content,
                            'other',
                            'msg',
                            message.regdate
                        );
                    }
                };

                ws.onclose = (evt) => {
                    log('서버와 연결이 종료되었습니다.');
                };

                ws.onerror = (evt) => {
                    log('에러가 발생했습니다.');
                };
            }
            function log(msg) {
                // console.log(`[시각] 메시지`);
                console.log(`[\${new Date().toLocaleTimeString()}] \${msg}`);
            }

            $('#msg').on('keydown', (evt) => {
                if (evt.keyCode === 13) {
                    // 대화 내용을 서버로 전송하기

                    const message = {
                        code: 3,
                        sender: this.name,
                        content: $(evt.target).val(),
                        regdate: dayjs().format('YYYY-MM-DD HH:mm:ss'),
                    };

                    if ($(evt.target).val().startsWith('/')) {
                        message.code = 4;
                    }

                    if (message.code == '3') {
                        print(
                            message.sender,
                            message.content,
                            'me',
                            'msg',
                            message.regdate
                        );
                    } else if (message.code == '4') {
                        printEmoticon(
                            message.sender,
                            message.content,
                            'me',
                            'msg',
                            message.regdate
                        );
                    }

                    ws.send(JSON.stringify(message));
                    $('#msg').val('');
                }
            });

            // 창을 종료했을 때
            window.onunload = () => {
                // opener.document.title = 'aaa';

                $(opener.document).find('#name').prop('readOnly', false);
                $(opener.document).find('#name').val('');
                $(opener.document).find('#name').focus();

                $(opener.document).find('.in').prop('disabled', false);
                $(opener.document).find('.in').css('opacity', 1);

                // 서버에게 종료한다고 알리기
                disconnect();
            };

            function disconnect() {
                // 소켓 연결 종료

                const message = {
                    code: 2,
                    sender: this.name,
                    receiver: '',
                    content: '',
                    regdate: '2024-10-24 12:24:10',
                    regdate: dayjs().format('YYYY-MM-DD HH:mm:ss'),
                };

                ws.send(JSON.stringify(message));
            }

            function print(name, msg, side, state, time) {
                let temp = `
					<div class="item \${state} \${side}">
						<div>
							<div>\${name}</div>
							<div>\${msg}</div>
						</div>
						<div>\${time}</div>
					</div>
				`;

                $('#list').append(temp);

                scrollList();
            }

            function printEmoticon(name, msg, side, state, time) {
                let temp = `
					<div class="item \${state} \${side}">
						<div>
							<div>\${name}</div>
							<div><img src="/socket/resources/emoticon\${msg}.png"></div>
						</div>
						<div>\${time}</div>
					</div>
				`;

                $('#list').append(temp);

                scrollList();
            }

            function scrollList() {
                $('#list').scrollTop($('#list')[0].scrollHeight + 1000);
            }
        </script>
    </body>
</html>
