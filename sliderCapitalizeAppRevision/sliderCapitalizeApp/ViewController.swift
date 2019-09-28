//
//  ViewController.swift
//  sliderCapitalizeApp
//
//  Created by Chris Vecchio on 9/12/19.
//  Copyright © 2019 Chris Vecchio. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var porscheImage: UIImageView!
    
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var imageControl: UISegmentedControl!
    
    @IBOutlet weak var fontSizeLabel: UILabel!
    
    @IBOutlet weak var capitalSwitch: UISwitch!
    
    @IBOutlet weak var colorSwitch: UISwitch!
    
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0{
            titleLabel.text = "Porsche 911"
            porscheImage.image=UIImage (named:"911")
        }
        else if imageControl.selectedSegmentIndex == 1{
            titleLabel.text = "Porsche Panamera"
            porscheImage.image=UIImage (named:"panamera")
        }
        else if imageControl.selectedSegmentIndex == 2{
            titleLabel.text = "Porsche Cayenne"
            porscheImage.image=UIImage (named:"cayenne")
        }
    }
    func updateCaps(){
        if capitalSwitch.isOn {
            titleLabel.text = titleLabel.text?.uppercased()
        }else{
            titleLabel.text = titleLabel.text?.lowercased()
        }
    }
    func colorChange(){
        if colorSwitch.isOn {
            titleLabel.textColor = UIColor.black
        }else{
            titleLabel.textColor = UIColor.red
        }
    }
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
    //_ means there is no external parameter name (being called from storyboard, sender is internal/local name
//        if imageControl.selectedSegmentIndex == 0{
//            titleLabel.text = "Porsche 911"
//            porscheImage.image=UIImage (named:"911")
//        }
//        else if imageControl.selectedSegmentIndex == 1{
//            titleLabel.text = "Porsche Panamera"
//            porscheImage.image=UIImage (named:"panamera")
//        }
//        else if imageControl.selectedSegmentIndex == 2{
//            titleLabel.text = "Porsche Cayenne"
//            porscheImage.image=UIImage (named:"cayenne")
//        }
//
        updateImage()
        updateCaps()
    }
    
    @IBAction func updateColor(_ sender: UISwitch) {
        colorChange()
    }
    @IBAction func updateFont(_ sender: UISwitch) {
//        if sender.isOn {
//            titleLabel.text = titleLabel.text?.uppercased()
//        }else{
//            titleLabel.text = titleLabel.text?.lowercased()
//        }
        updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize = sender.value
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        titleLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    

}


