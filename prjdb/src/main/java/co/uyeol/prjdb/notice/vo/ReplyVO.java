package co.uyeol.prjdb.notice.vo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	
	private int replyId;
	
	private String replyWriter;
	
	private String replySubject;
	
	private LocalDate replyEnterDate;
	
	private LocalDate replyUpdateDate;
	
	private int noticeId;
	
}
