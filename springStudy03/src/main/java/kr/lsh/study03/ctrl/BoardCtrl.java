package kr.lsh.study03.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.lsh.study03.db.BoardDAO;
import kr.lsh.study03.model.BoardVO;

@Controller
public class BoardCtrl {
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping(value="/write.do", method = RequestMethod.GET)
	public String goWrite(Model model, @ModelAttribute BoardVO vo) {
		model.addAttribute("vo",vo);
		
		return"/spring/write";
	}
	
	@RequestMapping(value="/write.do", method = RequestMethod.POST)
	public String doWrite(Model model, @ModelAttribute BoardVO vo) {
		int result = boardDAO.wirteBoard(vo);
		if(result != 1) {//글 작성 실패
			model.addAttribute("msg","글 쓰기에 실패했습니다.");
			return"redirect:/write.do";
		}
		return"redirect:/list.do";
	}
	
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String goList(Model model) {
		model.addAttribute("list", boardDAO.getList());
		return"spring/list";
	}
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String goDetail(Model model, @RequestParam (value="pk", required = false, defaultValue = "0") int pk) {
		if(pk==0) {
			return"redirect:/wirte.do";
		}
		BoardVO vo = new BoardVO();
		vo.setPk(pk);
		model.addAttribute("one",boardDAO.getOne(vo));
		
		
		return"/spring/detail";
	}
	@RequestMapping(value="/del.do", method = RequestMethod.GET)
	public String goDel(Model model, @RequestParam(value="pk", required = false, defaultValue = "0") int pk ){
		if(pk==0) {
			return"redirect:/wirte.do";
		}
		BoardVO vo = new BoardVO();
		vo.setPk(pk);
		int result = boardDAO.delBoard(vo);
		if(result != 1) {//삭제에 문제발생
			model.addAttribute("msg", "삭제에 실패했습니다.");
		}
		return"redirect:/list.do";
	}
	@RequestMapping(value="/mod.do", method = RequestMethod.GET)
	public String goMod(Model model, @RequestParam (value="pk", required = false, defaultValue = "0")int pk) {
		if(pk==0) {
			return"redirect:/list.do";
		}
		
		BoardVO param = new BoardVO();
		param.setPk(pk);
		model.addAttribute("one", boardDAO.getOne(param));
		
		
		return "/spring/update";
	}
	@RequestMapping(value="/mod.do", method = RequestMethod.POST)
	public String doMod(Model model, @ModelAttribute BoardVO param) {
		int result = 0;
		result = boardDAO.updBoard(param);
		System.out.println("result:"+result);
		if(result != 1) {//수정이상
			model.addAttribute("msg","수정에 실패했습니다.");
			return "redirect:/mod.do?pk="+param.getPk();
		}
		return"redirect:/list.do";
	}
	
	
}
