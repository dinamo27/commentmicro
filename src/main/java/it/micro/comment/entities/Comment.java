package it.micro.comment.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import it.micro.comment.dto.CommentDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@SuppressWarnings("unused")
@EntityListeners(AuditingEntityListener.class)
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comment;
	private Integer deleted = 0;
	// Auditing
	@CreatedDate
	@Column(name = "comment_date", updatable = false)
	private Timestamp commentDate;
	@LastModifiedDate
	@Column(name = "modify_time")
	private Long modifyTime;
	@CreatedBy
	@Column(name = "commenter_id", updatable = false)
	private Long commenterId;
	@LastModifiedBy
	@Column(name = "modify_by")
	private Long modifyBy;

	public Comment(CommentDto commentDto) {
		this.id = commentDto.getId() != null ? commentDto.getId() : null;
		this.comment = commentDto.getComment() != null ? commentDto.getComment() : null;
		this.deleted = commentDto.getDeleted() != null ? commentDto.getDeleted() : 0;

	}

}
