/**
 * webapp > asset > js > main.js
 */
 
 // document 내용이 모두 로딩된 후에 이벤트가 설정되어야 하기 때문에
 // ready event에 ajax 내용을 집어 넣음
 // $(document).ready(() => { > DOM 객체만
window.onload = () => {
	// 댓글 쓰기
	$('#btnAddComment').click(() => {

		$.ajax({
			type: 'POST',
			url: '/toy/board/addcomment.do',
			data: {
				content: $('#addComment input[name=content]').val(),
				bseq: $('#view tr:nth-child(1) td:last-child').text()
			},
			dataType: 'json',
			success: function(result) {
				// console.log(result);
				
				if(result.result == 1) {
					// alert("댓글 쓰기 성공");
					loadComment();
					$('#addComment input[name=content]').val('');
				} else {
					// alert("댓글 쓰기 실패");
				}
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});
	});	

	// 댓글 목록 가져오기
	function loadComment() {
		$.ajax({
			type: 'GET',
			url: '/toy/board/listcomment.do',
			data: {
				bseq: $('#view tr:nth-child(1) td:last-child').text()
			},
			dataType: 'json',
			success: function(list) {
				$('#comment tbody').html('');
				
				list.forEach((dto) => {
					let temp = `
					<tr data-seq="${dto.seq}">
						<td>
							<div>${dto.content.replace(/</g, '&lt;').replace(/>/g, '&gt;')}</div>
							<div>${dto.regdate}</div>
						</td>
						<td>
							<div>
								<div>${dto.name}(${dto.id})</div>
								`;
					if (lv != 0 && (id == dto.id || lv == 2)) {
						temp += `
									<div>
										<span class="material-symbols-outlined" onclick="delComment(${dto.seq})">delete</span>
										<span class="material-symbols-outlined" onclick="editComment(${dto.seq})">edit_note</span>
									</div>
								`;
					}
					temp += `
							</div>
						</td>
					</tr>
					`;
					$('#comment tbody').append(temp);
				});
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});
	}
	
	$('#addComment input[name=content]').keydown((event) => {
		if (event.keyCode == 13) {
			$('#btnAddComment').click();
		}
	})
	//
	/*
	function delComment(cseq) {
	}
	*/
	
	// 좋아요
	$('#btnGood').click(() => {
		$.ajax({
			type: 'POST',
			url: '/toy/board/goodbad.do',
			data: {
				state: 1,
				bseq: $(event.target).data('seq')
			},
			dataType: 'json',
			success: function(result) {
				// alert(result.result);
				
				loadGoodBad();
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		})
	});
	
	$('#btnBad').click(() => {
		$.ajax({
			type: 'POST',
			url: '/toy/board/goodbad.do',
			data: {
				state: 0,
				bseq: $(event.target).data('seq')
			},
			dataType: 'json',
			success: function(result) {
				// alert(result.result);
				loadGoodBad();
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		})
	});
	
	function loadGoodBad() {
		$.ajax({
			type: 'POST',
			url: '/toy/board/loadgoodbad.do',
			data: {
				bseq: bseq
			},
			dataType: 'json',
			success: function(result) {
				//  console.log(result);
				
				// alert(result.state);
				if (result.state == '1') {
					$('#btnGood').css('color', 'cornflowerblue');
					$('#btnBad').css('color', '#555');
				} else if (result.state == '0') {
					$('#btnGood').css('color', '#555');
					$('#btnBad').css('color', 'tomato');
				}
				
				$('#good').text(0);
				$('#bad').text(0);
				
				$(result.arr).each((index, item) => {
					if (item.state == '1') {
						$('#good').text(item.cnt);
					} else if (item.state == '0') {
						$('#bad').text(item.cnt);
					}
				})
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});
	}
	
	if (location.href.indexOf('view.do') > -1) {
		loadComment();
		loadGoodBad();	
	}
};

function delComment(cseq) {
	if(!confirm('정말 삭제하겠습니까?')){
		return;
	}
	
	const tr = $(event.target).parents('tr');
	console.log(tr[0].nodeName);
	
	$.ajax({
		type: 'POST',
		url: '/toy/board/delcomment.do',
		data: {
			cseq: cseq
		},
		success: function(result) {
			if(result.result == '1') {
				tr.remove();
			} else {
				alert('댓글 삭제 실패');
			}
		},
		error: function(a, b, c) {
			console.log(a, b, c);
		}
	});
}

let temp_content;

function editComment(cseq) {
	
	// 이전 눌렀던 수정 폼을 되돌리기
	$('#comment tbody tr')
		.find('input[type=text]')
		.each((index, item) => {
			const content = $(item).val();
			$(item).parent().html(content);
		});
	
	const div = $(event.target).parents('tr').find('td:first-child div:first-child');
	const content = div.text();
	
	temp_content = content;
	
	div.html('');
	
	$('<input type="text" style="width: 535px;">')
		.val(content)
		.keydown((evt) => {
			// alert(evt.keyCode);
			// enter를 누르면 수정, esc키를 누르면 수정 취소
			if (evt.keyCode == 13) {
				
				const txt = $(evt.target);
				
				$.ajax({
					type: 'POST',
					url: '/toy/board/editcomment.do',
					data: {
						content: txt.val(),
						seq: txt.parents('tr').data('seq')
					},
					dataType: 'json',
					success: function(result) {
						const content = txt.val();
						txt.parent().html(content);
					},
					error: function(a, b, c) {
						
					}
				});
			} else if(evt.keyCode == 27) {
				const content = temp_content;
				$(evt.target).parent().html(content);
			}
		})
		.appendTo(div);
}