export type CameraInfo = {
    name:string
    imageUrl:string
    price:number
    totalRatings:number
}

export type StartDecoProps = {
  bgColor?: string, 
  startColor?: string, 
  startSize?: number, 
  position?: string, 
  padding?: string
}
export type FooterContentProps = {
  name:string,
  links:{
    name?:string,
    link?:string,
    email?:string,
    phone?:string
  }[]
}