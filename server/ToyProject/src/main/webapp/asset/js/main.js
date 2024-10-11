/**
 * webapp > asset > js > main.js
 */
 
 // document 내용이 모두 로딩된 후에 이벤트가 설정되어야 하기 때문에
 // ready event에 ajax 내용을 집어 넣음
 $(document).ready(() => {
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
							<div>${dto.content}</div>
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
	
	loadComment();
	
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
});

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
				const content = $(evt.target).val();
				$(evt.target).parent().html(content);
			}
		})
		.appendTo(div);
}