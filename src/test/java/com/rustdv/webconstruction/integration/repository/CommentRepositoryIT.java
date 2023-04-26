package com.rustdv.webconstruction.integration.repository;

import com.rustdv.webconstruction.entity.Comment;
import com.rustdv.webconstruction.entity.Person;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.repository.CommentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentRepositoryIT extends IntegrationTestBase {

    CommentRepository commentRepository;

    @Test
    void saveComment() {
        var comment = Comment.builder()
                .comment("some not long message just for test")
                .build();

        var recipient = Person.builder()
                .id(10)
                .firstName("Rustam")
                .build();
        var sender = Person.builder()
                .id(11)
                .firstName("Nikita")
                .build();

        sender.addSentComments(comment);
        recipient.addReceivedComments(comment);
        commentRepository.save(comment);

        var actualComment = commentRepository.findById(comment.getId());

        assertThat(actualComment).isPresent();
        assertThat(actualComment.get()).isEqualTo(comment);
        assertThat(actualComment.get().getRecipient().getFirstName()).isEqualTo(recipient.getFirstName());
        assertThat(actualComment.get().getSender().getFirstName()).isEqualTo(sender.getFirstName());



    }
}
