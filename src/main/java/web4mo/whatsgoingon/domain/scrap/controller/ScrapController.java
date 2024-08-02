package web4mo.whatsgoingon.domain.scrap.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web4mo.whatsgoingon.domain.scrap.dto.ScrapPageDto;
import web4mo.whatsgoingon.domain.scrap.service.ScrapService;
import web4mo.whatsgoingon.response.Response;

import static org.springframework.http.HttpStatus.OK;
import static web4mo.whatsgoingon.response.Message.*;
import static web4mo.whatsgoingon.response.Response.success;

@RestController
@RequiredArgsConstructor
@Tag(name = "Scrap Controller")
@RequestMapping(value="/scraping")
public class ScrapController {
    private final ScrapService scrapService;
    @GetMapping("/")
    @ResponseStatus(OK)
    @Transactional // 메인 페이지에서 스크랩 버튼 눌렀을때
    public Response scrapMain(@RequestParam(value = "articleId")Long articleId){
        String articleContent = scrapService.scrapMain(articleId);
        return success(SCRAP_MAIN, articleContent);
    }

    @GetMapping("/")
    @ResponseStatus(OK)
    @Transactional
    public Response scrapPage(@RequestParam(value = "scrapId")Long scrapId){
        ScrapPageDto scrapPageDto = scrapService.scrapPage(scrapId);
        return success(SCRAP_PAGE, scrapPageDto);
    }

    @DeleteMapping("/")
    @ResponseStatus(OK)
    public Response deleteScrap(@RequestParam(value = "scrapId")Long scrapId){
        scrapService.deleteScrap(scrapId);
        return success(DELETE_SCRAP);
    }

    @PutMapping("/")
    @ResponseStatus(OK)
    @Transactional
    public Response scrapMemo(@RequestParam(value = "scrapId")Long scrapId,
                              @RequestParam(value = "memo")String memo){
        scrapService.scrapMemo(scrapId, memo);
        return success(SCRAP_MEMO);
    }
    @PostMapping("/")
    @ResponseStatus(OK)
    @Transactional
    public Response scrapAI(@RequestParam(value = "scrapId")Long scrapId){
        String response = scrapService.scrapAI(scrapId);
        return success(SCRAP_AI, response);
    }

}
