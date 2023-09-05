package co.uyeol.prjdb.notice.vo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {

	private int noticeId;
	
	private String noticeWriterId;
	
	private String noticeTitle;
	
	private String noticeSubject;
	
	private LocalDate noticeDate;
	
	private int noticeHit;
	
	private String noticeAttach;
	
	private String noticeImg;
	
	private String noticeWriterName;
	
	private String noticeThumb;
	
}
