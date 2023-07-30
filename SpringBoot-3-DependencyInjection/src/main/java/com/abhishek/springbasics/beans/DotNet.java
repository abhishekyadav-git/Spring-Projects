package com.abhishek.springbasics.beans;

import org.springframework.stereotype.Component;

@Component("dotNet")
public final class DotNet implements IChooseSem_1_Optionals {

	@Override
	public String courseContent() {
		return "1 : C#  2 : Oops etc...";
	}

	@Override
	public int courseRating() {
		return 3;
	}

}
