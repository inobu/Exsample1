package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {
	@Autowired
	private SampleEntityRepository sampleEntityRepository;

	// トップページのマッピング
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		List<SampleEntity> sampleEntityList = sampleEntityRepository.findAll();
		mv.addObject("repositorys", sampleEntityList);
		return mv;
	}

	// 新規車情報入力画面へ遷移
	@RequestMapping("/insert")
	public ModelAndView insert(ModelAndView mv) {
		mv.setViewName("insert");
		mv.addObject("sampleEntity", new SampleEntity());
		return mv;
	}

	// 車情報編集画面へ遷移
	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public ModelAndView edit(ModelAndView mv, @ModelAttribute SampleEntity sampleEntity, int id) {
		sampleEntity = sampleEntityRepository.findOne(id);
		mv.setViewName("edit");
		mv.addObject("repository", sampleEntity);
		return mv;
	}

	// 車情報を新規追加/更新を行う
	@RequestMapping(value = { "/saveAndFlush" }, params = "saveAndFlush", method = { RequestMethod.POST })
	public ModelAndView saveAndFlush(ModelAndView mv, @ModelAttribute SampleEntity sampleEntity, BindingResult br) {
		sampleEntityRepository.saveAndFlush(sampleEntity);
		List<SampleEntity> sampleEntityList = sampleEntityRepository.findAll();
		mv.setViewName("index");
		mv.addObject("repositorys", sampleEntityList);
		return mv;
	}

	// 車情報を削除する
	@RequestMapping(value = { "/saveAndFlush" }, params = "delete", method = { RequestMethod.POST })
	public ModelAndView delete(ModelAndView mv, int id) {

		// 指定したIDが存在すれば削除
		if (sampleEntityRepository.findOne(id) == null) {
		} 
		else {
			sampleEntityRepository.delete(id);
		}

		List<SampleEntity> sampleEntityList = sampleEntityRepository.findAll();
		mv.setViewName("index");
		mv.addObject("repositorys", sampleEntityList);
		return mv;
	}
}
