package com.happymama.admin.controller;

import com.happymama.admin.constant.Constant;
import com.happymama.admin.model.EmployeeDO;
import com.happymama.admin.model.KnowledgeDO;
import com.happymama.admin.service.KnowledgeService;
import com.happymama.admin.utils.FileUtils;
import com.happymama.admin.utils.PageView;
import com.happymama.admin.utils.QueryResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by yaoqiang on 2018/6/22.
 */
@Controller
public class KnowledgeController {

    @Resource
    private KnowledgeService knowledgeService;

    @RequestMapping(value = "/admin/knowledge/add", method = RequestMethod.POST)
    public String addKnowledge(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam MultipartFile photo,
            @RequestParam(required = false, defaultValue = "0") int type,
            ModelMap modelMap) throws ParseException, IOException

    {
        String path = FileUtils.saveFile(photo);
        knowledgeService.addKnowledge(KnowledgeDO.builder().title(title).content(content).img(path == null ? StringUtils.EMPTY : path).type(type).build());
        modelMap.addAttribute("message", "增加成功");
        return "/share/result";
    }

    @RequestMapping(value = "/admin/to/knowledge/add", method = RequestMethod.GET)
    public String toAddKnowledge(
            ModelMap modelMap) throws ParseException, IOException

    {
        return "/knowledge/add";
    }

    @RequestMapping("/admin/knowledge/list")
    public String toKnowledgeListPage(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "1") int page,
            ModelMap modelMap) {
        if (limit > 100) {
            limit = Constant.pageSize;
        }
        PageView<KnowledgeDO> pageView = new PageView<>(limit, page);
        QueryResult<KnowledgeDO> qr = knowledgeService.getKnowledgeList(pageView.getFirstResult(), pageView.getMaxresult());
        pageView.setQueryResult(qr);
        modelMap.addAttribute("pageView", pageView);
        return "/knowledge/list";
    }

    @RequestMapping(value = "/admin/{id}/knowledge/delete", method = RequestMethod.GET)
    public String deleteKnowledge(@PathVariable int id, ModelMap modelMap

    ) {
        knowledgeService.deleteKnowledgeById(id);
        modelMap.addAttribute("message", "删除成功");
        modelMap.addAttribute("nextUrl", "/admin/knowledge/list.do");
        modelMap.addAttribute("nextStep", "继续删除");
        return "/share/result";
    }

    @RequestMapping(value = "/admin/{id}/knowledge/to/update", method = RequestMethod.GET)
    public String toUpdateKnowledge(@PathVariable int id, ModelMap modelMap

    ) {
        KnowledgeDO knowledgeDO = knowledgeService.getKnowledgeById(id);
        modelMap.addAttribute("knowledgeDO", knowledgeDO);
        return "/knowledge/edit";
    }

    @RequestMapping(value = "/admin/{id}/knowledge/update", method = RequestMethod.POST)
    public String updateEmployee(
            @PathVariable int id,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam MultipartFile photo,
            @RequestParam(required = false, defaultValue = "0") int type,
            ModelMap modelMap

    ) throws IOException, ParseException {
        String path = FileUtils.saveFile(photo);
        knowledgeService.updateKnowledge(KnowledgeDO.builder().title(title).content(content).img(path).type(type).build());
        modelMap.addAttribute("message", "增加成功");
        return "/share/result";
    }


}
