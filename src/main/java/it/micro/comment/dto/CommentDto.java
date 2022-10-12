package it.micro.comment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import it.micro.comment.entities.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@XmlRootElement(name = "CommentDto") // serve per il marshal di jaxb
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentDto {

	private Long id;
	@NotBlank
	@Size(min = 1, max = 200)
	private String comment;
	private Integer deleted;
	private Long commenterId;
	private Long commentDate;

	public CommentDto(@NonNull Comment commentEntity) {
		this.id = commentEntity.getId();
		this.comment = commentEntity.getComment() != null ? commentEntity.getComment() : null;
		this.deleted = commentEntity.getDeleted() != null ? commentEntity.getDeleted() : null;
		this.commenterId = commentEntity.getCommenterId() != null ? commentEntity.getCommenterId() : null;
		this.commentDate = commentEntity.getCommentDate() != null ? commentEntity.getCommentDate().getTime() : null;
	}

}
