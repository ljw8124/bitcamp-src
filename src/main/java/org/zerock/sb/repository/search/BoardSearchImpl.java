package org.zerock.sb.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.sb.entity.Board;
import org.zerock.sb.entity.QBoard;

import java.util.List;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(char[] typeArr, String keyword, Pageable pageable) {
        log.info("....................search1...........................");

        //표준방식
        QBoard board = QBoard.board;

        JPQLQuery<Board> jpqlQuery = from(board);

        if (typeArr != null && typeArr.length > 0) {

            BooleanBuilder condition = new BooleanBuilder();

            for(char type: typeArr) {
                if(type == 'T') {
                    condition.or(board.title.contains(keyword));
                } else if(type == 'C') {
                    condition.or(board.content.contains(keyword));
                } else if(type == 'W') {
                    condition.or(board.writer.contains(keyword));
                }
            }
            jpqlQuery.where(condition);
        }

        jpqlQuery.where(board.bno.gt(0L)); //bno > 0, gt -> greater
        JPQLQuery<Board> pagingQuery = this.getQuerydsl().applyPagination(pageable, jpqlQuery);

        List<Board> boardList = pagingQuery.fetch();
        Long totalCount = pagingQuery.fetchCount();

        return new PageImpl<>(boardList, pageable, totalCount);

    }
}
